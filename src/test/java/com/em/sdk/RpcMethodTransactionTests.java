package com.em.sdk;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.DefaultBlockParameterName;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.core.protocol.core.methods.request.AssetInfo;
import com.em.sdk.core.protocol.core.methods.response.EMGetTransactionCount;
import com.em.sdk.core.protocol.core.methods.response.EMGetTransactionReceipt;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;
import com.em.sdk.core.protocol.core.methods.response.EMTransaction;
import com.em.sdk.core.protocol.core.methods.response.Transaction;
import com.em.sdk.core.protocol.core.methods.response.TransactionReceipt;
import com.em.sdk.core.protocol.http.HttpService;
import com.em.sdk.core.utils.EmGas;
import com.em.sdk.utils.Convert;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author yujian    2020/05/20
 */
public class RpcMethodTransactionTests {

    private Web3j web3j;

    @Before
    public void init() {
        web3j = Web3j.build(new HttpService("http://172.16.20.76:8545"));
    }


    /**
     * 交易查询
     * 1. 普通交易 success
     * 2. 注册代理交易 success
     * 3. 投票(加票)交易 success
     * 4. 投票(减票)交易 success
     * 5. 注册多资产交易 success
     * 6. 多资产转账交易 success
     */
    @Test
    public void getTransactionByHash() throws Exception {
        String trxId = "0xd295457a7004b45f12b459405b91cff179613aafa0df7f52279d602edf0563c2";
        Request<?, EMTransaction> request = web3j.emGetTransactionByHash(trxId);
        Transaction transaction = request.sendAsync().get().getResult();
        System.out.println(transaction);
        System.out.println(transaction.getTransactionAction());
    }

    @Test
    public void getTransactionReceipt() throws Exception {
        String trxId = "0xd295457a7004b45f12b459405b91cff179613aafa0df7f52279d602edf0563c2";
        Request<?, EMGetTransactionReceipt> request = web3j.emGetTransactionReceipt(trxId);
        TransactionReceipt transactionReceipt = request.sendAsync().get().getResult();
        System.out.println(transactionReceipt);
    }

    @Test
    public void sendEMTransaction() throws Exception {
        // 需节点本地存在该账户
        String from = "EM8ea2354ba012628dd1dad9e44500a70075664a16";
        String to = "EM267a2f33c924a3b1d751a86689d4a0667341178b";
        String md5Value = "202cb962ac59075b964b07152d234b70";
        // 子地址
        to += md5Value;
        String transferEmAmount = "1.02";
        Request<?, EMGetTransactionCount> nonceRequest =
            web3j.emGetTransactionCount(from, DefaultBlockParameterName.LATEST);
        BigInteger nonce = nonceRequest.sendAsync().get().getTransactionCount();

        BigInteger value = Convert.toWei(transferEmAmount, Convert.Unit.EM).toBigInteger();
        BigInteger gas = EmGas.defaultTrxGas.toBigInteger();
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();

        com.em.sdk.core.protocol.core.methods.request.Transaction transaction =
            com.em.sdk.core.protocol.core.methods.request.Transaction
                .createEMTransaction(from, to, nonce, value, gas, gasPrice);

        EMSendTransaction emSendTransaction = web3j.emSendTransaction(transaction).sendAsync().get();

        if(emSendTransaction.getError() != null) {
            System.err.printf("send trx fail,error:%s\n", emSendTransaction.getError().getMessage());
        }else {
            System.err.printf("send trx success,trxHash:%s\n", emSendTransaction.getResult());
        }
    }

    // 失败
    @Test
    public void sendAssetPublishTransaction() throws Exception {
        String from = "EM8ea2354ba012628dd1dad9e44500a70075664a16";

        Request<?, EMGetTransactionCount> request =
            web3j.emGetTransactionCount(from, DefaultBlockParameterName.LATEST);

        BigInteger nonce = request.sendAsync().get().getTransactionCount();
        BigInteger gas = BigInteger.valueOf(100_000);
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();

        BigInteger supply = Convert.toWei("10000", Convert.Unit.EM).toBigInteger();
        AssetInfo assetInfo = new AssetInfo("yujianEM", "YUY", supply, "yujian token");

        com.em.sdk.core.protocol.core.methods.request.Transaction transaction =
            com.em.sdk.core.protocol.core.methods.request.Transaction
                .createAssetPublishTransaction(from, nonce, gas, gasPrice, assetInfo);

        Request<?, EMSendTransaction> trxRequest = web3j.emSendTransaction(transaction);

        EMSendTransaction emSendTransaction = trxRequest.sendAsync().get();

        if (emSendTransaction.getError() == null) {
            System.err.printf("send trx success,trxHash:%s\n", emSendTransaction.getResult());
        } else {
            System.err.printf("send trx fail,error:%s\n", emSendTransaction.getError().getMessage());
        }
    }





}

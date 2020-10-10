package com.em.sdk;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.DefaultBlockParameterName;
import com.em.sdk.core.protocol.core.methods.request.AssetInfo;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;
import com.em.sdk.core.protocol.http.HttpService;
import com.em.sdk.core.tx.ChainId;
import com.em.sdk.core.utils.EmGas;
import com.em.sdk.crypto.Credentials;
import com.em.sdk.crypto.RawTransaction;
import com.em.sdk.crypto.TransactionDecoder;
import com.em.sdk.crypto.TransactionEncoder;
import com.em.sdk.utils.Convert;
import com.em.sdk.utils.Numeric;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author yujian    2020/05/20
 */
public class RpcMethodRawTransactionTests {

    private Web3j web3j;

    @Before
    public void init() {
        web3j = Web3j.build(new HttpService("http://172.16.20.76:8545"));
    }

    private final String testAddress = "EM2e25d6f13330163134b9e321491ca0d45233e054";
    private final String testPublicKey =
        "d12e322b4c9aa37c09883c957561f1a68a474957823f5a27f21fbd0ba22e830c411f1e1ccd0058cb9b52e20c0123555fb8fdd9817b48143c070d080328d46fa5";
    private final String testPrivateKey = "b968d08d67b3664bebd6b11b517557a29186e3c5f8474959d5db7cc0442b1831";


    @Test
    public void sendEMRawTransaction() throws Exception {
        String from = testAddress;
        // String to = "EM8ea2354ba012628dd1dad9e44500a70075664a16";
        // 带子地址的to
        String to = "EM8ea2354ba012628dd1dad9e44500a70075664a16" + "202cb962ac59075b964b07152d234b70";
        Credentials credentials = Credentials.create(testPrivateKey);
        BigInteger nonce = web3j.emGetTransactionCount(from, DefaultBlockParameterName.LATEST)
                                .sendAsync().get().getTransactionCount();


        BigInteger value = Convert.toWei("1.01", Convert.Unit.EM).toBigInteger();
        BigInteger gas = EmGas.defaultTrxGas.toBigInteger();
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();
        RawTransaction rawTransaction = RawTransaction.createEMTransaction(nonce, gasPrice, gas, to, value);

        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, ChainId.MAINNET, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        System.err.printf("sign Hex:%s\n", hexValue);
        EMSendTransaction emSendTransaction = web3j.emSendRawTransaction(hexValue).sendAsync().get();
        if (emSendTransaction.getError() != null) {
            System.err.printf("sendRawTransaction error:%s\n", emSendTransaction.getError().getMessage());
        } else {
            String transactionHash = emSendTransaction.getTransactionHash();
            System.err.printf("sendRawTransaction success,trxHash:%s\n", transactionHash);
        }
    }

    @Test
    public void offlineSignTransaction() throws Exception {
        String from = testAddress;
        // String to = "EM8ea2354ba012628dd1dad9e44500a70075664a16";
        // 带子地址的to
        String to = "EM8ea2354ba012628dd1dad9e44500a70075664a16" + "202cb962ac59075b964b07152d234b70";
        Credentials credentials = Credentials.create(testPrivateKey);
        BigInteger nonce = new BigInteger("2");

        BigInteger value = Convert.toWei("1.01", Convert.Unit.EM).toBigInteger();
        BigInteger gas = EmGas.defaultTrxGas.toBigInteger();
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();
        RawTransaction rawTransaction = RawTransaction.createEMTransaction(nonce, gasPrice, gas, to, value);

        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, ChainId.MAINNET, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        System.err.printf("sign Hex: %s\n", hexValue);
    }

    @Test
    public void testDecodeRawSign() throws Exception {
        String hexRaw = "0xf8bd0284ee6b28008261a8948ea2354ba012628dd1dad9e44500a70075664a16880e043da617250000808080808080b84a454d3865613233353462613031323632386464316461643965343435303061373030373536363461313632303263623936326163353930373562393634623037313532643233346237308026a0b96da6a1b931cd63c1d53a26610d4b24df8d3fb6c71722c84413c911fcdadd4ba05de7e209bde928614bf49d031d03600d973eae5daf8447a6f32607cf2809744c";
        RawTransaction rawTransaction = TransactionDecoder.decode(hexRaw);
        System.out.println(rawTransaction);
    }

    @Test
    public void sendAssetPublishTransaction() throws Exception {
        String from = testAddress;
        Credentials credentials = Credentials.create(testPrivateKey);
        BigInteger nonce = web3j.emGetTransactionCount(from, DefaultBlockParameterName.LATEST)
                                .sendAsync().get().getTransactionCount();


        BigInteger gas = EmGas.defaultAssetPublishGas.toBigInteger();
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();
        BigInteger supply = Convert.toWei("10000", Convert.Unit.EM).toBigInteger();
        AssetInfo assetInfo = new AssetInfo("yujianAOA", "YU", supply, "yujian token");

        RawTransaction rawTransaction =
            RawTransaction.createAssetPublishTransaction(nonce, gasPrice, gas, assetInfo);
        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, ChainId.MAINNET, credentials);
        String hexValue = Numeric.toHexString(signedMessage);

        EMSendTransaction emSendTransaction = web3j.emSendRawTransaction(hexValue).sendAsync().get();
        if (emSendTransaction.getError() != null) {
            System.err.printf("sendRawTransaction error:%s\n", emSendTransaction.getError().getMessage());
        } else {
            String transactionHash = emSendTransaction.getTransactionHash();
            System.err.printf("sendRawTransaction success,trxHash:%s\n", transactionHash);
        }
    }

    // assetId : EM41941bd1a000215627ff23899c477feb9dfb2bd6
    @Test
    public void sendAssetTransaction() throws Exception {
        String from = testAddress;
        String to = "EM8ea2354ba012628dd1dad9e44500a70075664a16";
        String assetId = "EM41941bd1a000215627ff23899c477feb9dfb2bd6";
        Credentials credentials = Credentials.create(testPrivateKey);
        BigInteger nonce = web3j.emGetTransactionCount(from, DefaultBlockParameterName.LATEST)
                                .sendAsync().get().getTransactionCount();

        BigInteger gas = EmGas.defaultTrxGas.toBigInteger();
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();

        BigInteger value = Convert.toWei("1.01", Convert.Unit.EM).toBigInteger();
        RawTransaction rawTransaction = RawTransaction.createAssetTransaction(nonce, gasPrice, gas, to, value, assetId);

        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, ChainId.MAINNET, credentials);
        String hexValue = Numeric.toHexString(signedMessage);

        EMSendTransaction emSendTransaction = web3j.emSendRawTransaction(hexValue).sendAsync().get();
        if (emSendTransaction.getError() != null) {
            System.err.printf("sendRawTransaction error:%s\n", emSendTransaction.getError().getMessage());
        } else {
            String transactionHash = emSendTransaction.getTransactionHash();
            System.err.printf("sendRawTransaction success,trxHash:%s\n", transactionHash);
        }
    }



}

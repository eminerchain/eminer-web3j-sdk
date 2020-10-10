package com.em.sdk;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.DefaultBlockParameter;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.core.protocol.core.methods.response.EMBlock;
import com.em.sdk.core.protocol.core.methods.response.EMBlockNumber;
import com.em.sdk.core.protocol.core.methods.response.EMGetBlockTransactionCountByHash;
import com.em.sdk.core.protocol.core.methods.response.EMGetBlockTransactionCountByNumber;
import com.em.sdk.core.protocol.http.HttpService;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yujian    2020/05/20
 */
public class RpcMethodBlockTests {

    private Web3j web3j;

    @Before
    public void init() {
        web3j = Web3j.build(new HttpService("http://172.16.20.76:8545"));
    }

    @Test
    public void blockNumber() throws Exception {
        // curl -X POST -H "Content-Type:application/json" --data '{"jsonrpc":"2.0","method":"em_blockNumber",
        // "params":[],"id":67}' "172.16.20.76:8545"
        Request<?, EMBlockNumber> emBlockNumberRequest = web3j.emBlockNumber();
        EMBlockNumber result = emBlockNumberRequest.sendAsync().get();
        System.err.printf("blockNumber: %d\n", result.getBlockNumber());
    }

    @Test
    public void getBlockByNumber() throws Exception {
        int blockNumber = 2;
        Request<?, EMBlock> emBlockRequest =
            web3j.emGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(blockNumber)), false);
        EMBlock emBlock = emBlockRequest.sendAsync().get();
        System.out.println(emBlock.getBlock());
    }

    @Test
    public void getBlockByHash() throws Exception {
        String blockHash = "0xfb027c1623b540ba6d6fd5caf121ae47bc03170d21dff55007b7aacb846a8d4f";
        Request<?, EMBlock> emBlockRequest = web3j.emGetBlockByHash(blockHash, false);
        EMBlock emBlock = emBlockRequest.sendAsync().get();
        System.out.println(emBlock.getBlock());
    }

    @Test
    public void getBlockTransactionCountByHash() throws Exception {
        String blockHash = "0xfb027c1623b540ba6d6fd5caf121ae47bc03170d21dff55007b7aacb846a8d4f";
        Request<?, EMGetBlockTransactionCountByHash> request =
            web3j.emGetBlockTransactionCountByHash(blockHash);
        EMGetBlockTransactionCountByHash result = request.sendAsync().get();
        System.err.printf("transactionCount:%d\n", result.getTransactionCount());
    }

    @Test
    public void getBlockTransactionCountByNumber() throws Exception {
        int blockNumber = 3;
        Request<?, EMGetBlockTransactionCountByNumber> request =
            web3j.emGetBlockTransactionCountByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(blockNumber)));
        EMGetBlockTransactionCountByNumber result = request.sendAsync().get();
        System.err.printf("transactionCount:%d\n", result.getTransactionCount());
    }


    @Test
    public void blockSubscribe() throws Exception {
        web3j.blockObservable(true).subscribe(block -> {
            if (block.getResult() != null) {
                System.err.printf("blockReceive blockNumber:%d\n", block.getBlock().getNumber());
            }
        });
    }

    public static void main(String[] args) {

        Web3j web3j = Web3j.build(new HttpService("http://172.16.20.76:8545"));
        // 通过订阅模式来监听新块的产生
        web3j.blockObservable(true).subscribe(block -> {
            EMBlock.Block block1 = block.getBlock();
            List<EMBlock.TransactionResult> transactions = block1.getTransactions();
            System.err.printf("blockReceive blockNumber:%d\n", block.getBlock().getNumber());
        });
    }

}

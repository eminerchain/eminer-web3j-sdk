package com.em.sdk.core.tx;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;
import com.em.sdk.core.tx.response.TransactionReceiptProcessor;

import java.io.IOException;
import java.math.BigInteger;

/**
 * TransactionManager implementation for using an Aurora node to transact.
 *
 * <p><b>Note</b>: accounts must be unlocked on the node for transactions to be successful.
 */
public class ClientTransactionManager extends TransactionManager {

    private final Web3j web3j;

    public ClientTransactionManager(
            Web3j web3j, String fromAddress) {
        super(web3j, fromAddress);
        this.web3j = web3j;
    }

    public ClientTransactionManager(
            Web3j web3j, String fromAddress, int attempts, int sleepDuration) {
        super(web3j, attempts, sleepDuration, fromAddress);
        this.web3j = web3j;
    }

    public ClientTransactionManager(
            Web3j web3j, String fromAddress,
            TransactionReceiptProcessor transactionReceiptProcessor) {
        super(transactionReceiptProcessor, fromAddress);
        this.web3j = web3j;
    }

    @Override
    public EMSendTransaction sendTransaction(
        BigInteger gasPrice, BigInteger gasLimit, String to,
        String data, BigInteger value)
        throws IOException {
//
//        Transaction transaction = new Transaction(
//            getFromAddress(), null, gasPrice, gasLimit, to, value, data);
//
//        return web3j.aoaSendTransaction(transaction)
//                    .send();
        return null;
    }
}

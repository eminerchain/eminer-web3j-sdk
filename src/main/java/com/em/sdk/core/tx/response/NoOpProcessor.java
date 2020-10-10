package com.em.sdk.core.tx.response;



import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.methods.response.TransactionReceipt;
import com.em.sdk.core.protocol.exceptions.TransactionException;

import java.io.IOException;

/**
 * Return an {@link EmptyTransactionReceipt} receipt back to callers containing only the
 * transaction hash.
 */
public class NoOpProcessor extends TransactionReceiptProcessor {

    public NoOpProcessor(Web3j web3j) {
        super(web3j);
    }

    @Override
    public TransactionReceipt waitForTransactionReceipt(String transactionHash)
            throws IOException, TransactionException {
        return new EmptyTransactionReceipt(transactionHash);
    }
}

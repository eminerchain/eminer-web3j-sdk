package com.em.sdk.core.tx;



import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Transaction manager implementation for read-only operations on smart contracts.
 */
public class ReadonlyTransactionManager extends TransactionManager {

    public ReadonlyTransactionManager(Web3j web3j, String fromAddress) {
        super(web3j, fromAddress);
    }

    @Override
    public EMSendTransaction sendTransaction(
            BigInteger gasPrice, BigInteger gasLimit, String to, String data, BigInteger value)
            throws IOException {
        throw new UnsupportedOperationException(
                "Only read operations are supported by this transaction manager");
    }
}

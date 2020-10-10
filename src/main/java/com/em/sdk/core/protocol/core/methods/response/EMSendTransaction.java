package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_sendTransaction.
 */
public class EMSendTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}

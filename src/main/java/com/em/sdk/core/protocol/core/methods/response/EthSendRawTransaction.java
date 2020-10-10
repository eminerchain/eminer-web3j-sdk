package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_sendRawTransaction.
 */
public class EthSendRawTransaction extends Response<String> {
    public String getTransactionHash() {
        return getResult();
    }
}

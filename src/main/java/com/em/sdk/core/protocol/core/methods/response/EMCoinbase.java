package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_coinbase.
 */
public class EMCoinbase extends Response<String> {
    public String getAddress() {
        return getResult();
    }
}

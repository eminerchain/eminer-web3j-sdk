package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_call.
 */
public class EMCall extends Response<String> {
    public String getValue() {
        return getResult();
    }
}

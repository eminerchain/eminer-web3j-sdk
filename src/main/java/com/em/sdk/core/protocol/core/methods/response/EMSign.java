package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_sign.
 */
public class EMSign extends Response<String> {
    public String getSignature() {
        return getResult();
    }
}

package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_getCode.
 */
public class EMGetCode extends Response<String> {
    public String getCode() {
        return getResult();
    }
}

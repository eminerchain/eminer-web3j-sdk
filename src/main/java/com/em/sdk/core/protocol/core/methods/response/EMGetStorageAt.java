package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_getStorageAt.
 */
public class EMGetStorageAt extends Response<String> {
    public String getData() {
        return getResult();
    }
}

package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

import java.util.List;

/**
 * aoa_getCompilers.
 */
public class EMGetCompilers extends Response<List<String>> {
    public List<String> getCompilers() {
        return getResult();
    }
}

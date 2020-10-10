package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_compileLLL.
 */
public class EMCompileLLL extends Response<String> {
    public String getCompiledSourceCode() {
        return getResult();
    }
}

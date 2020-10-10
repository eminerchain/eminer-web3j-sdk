package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_compileSerpent.
 */
public class EMCompileSerpent extends Response<String> {
    public String getCompiledSourceCode() {
        return getResult();
    }
}

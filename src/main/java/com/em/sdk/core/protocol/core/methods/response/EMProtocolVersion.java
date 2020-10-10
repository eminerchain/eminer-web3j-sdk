package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * aoa_protocolVersion.
 */
public class EMProtocolVersion extends Response<String> {
    public String getProtocolVersion() {
        return getResult();
    }
}

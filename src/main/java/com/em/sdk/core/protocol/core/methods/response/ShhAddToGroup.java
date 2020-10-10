package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;

/**
 * shh_addToGroup.
 */
public class ShhAddToGroup extends Response<Boolean> {

    public boolean addedToGroup() {
        return getResult();
    }
}

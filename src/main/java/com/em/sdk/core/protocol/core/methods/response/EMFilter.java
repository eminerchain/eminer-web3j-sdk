package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;

/**
 * aoa_newFilter.
 */
public class EMFilter extends Response<String> {
    public BigInteger getFilterId() {
        return Numeric.decodeQuantity(getResult());
    }
}

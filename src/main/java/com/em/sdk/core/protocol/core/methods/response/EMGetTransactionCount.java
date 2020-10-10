package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;

/**
 * aoa_getTransactionCount.
 */
public class EMGetTransactionCount extends Response<String> {
    public BigInteger getTransactionCount() {
        return Numeric.decodeQuantity(getResult());
    }
}

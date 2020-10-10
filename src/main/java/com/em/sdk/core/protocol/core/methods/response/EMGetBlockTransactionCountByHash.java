package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;

/**
 * aoa_getBlockTransactionCountByHash.
 */
public class EMGetBlockTransactionCountByHash extends Response<String> {
    public BigInteger getTransactionCount() {
        return Numeric.decodeQuantity(getResult());
    }
}

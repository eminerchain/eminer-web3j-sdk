package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;

/**
 * aoa_blockNumber.
 */
public class EMBlockNumber extends Response<String> {
    public BigInteger getBlockNumber() {
        return Numeric.decodeQuantity(getResult());
    }
}

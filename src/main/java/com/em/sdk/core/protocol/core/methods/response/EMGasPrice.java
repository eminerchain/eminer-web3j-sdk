package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;

/**
 * aoa_gasPrice.
 */
public class EMGasPrice extends Response<String> {
    public BigInteger getGasPrice() {
        return Numeric.decodeQuantity(getResult());
    }
}

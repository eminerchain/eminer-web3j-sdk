package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.core.Response;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;

public class EMGetVotesNumber extends Response<String> {
    public BigInteger getVotesNumber() {
        return Numeric.decodeQuantity(getResult());
    }
}

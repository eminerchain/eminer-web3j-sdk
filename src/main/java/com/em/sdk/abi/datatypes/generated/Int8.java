package com.em.sdk.abi.datatypes.generated;


import com.em.sdk.abi.datatypes.Int;

import java.math.BigInteger;

/**
 * Auto generated code.
 * <p><strong>Do not modifiy!</strong>
 * <p>Please use org.web3j.codegen.AbiTypesGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 */
public class Int8 extends Int {
    public static final Int8 DEFAULT = new Int8(BigInteger.ZERO);

    public Int8(BigInteger value) {
        super(8, value);
    }

    public Int8(long value) {
        this(BigInteger.valueOf(value));
    }
}

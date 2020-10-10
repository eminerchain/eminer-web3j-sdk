package com.em.sdk.core.token;

import com.em.sdk.abi.TypeReference;
import com.em.sdk.abi.datatypes.Function;
import com.em.sdk.abi.datatypes.Type;
import com.em.sdk.abi.datatypes.generated.Uint256;
import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.RemoteCall;
import com.em.sdk.core.tx.Contract;
import com.em.sdk.core.tx.TransactionManager;
import com.em.sdk.crypto.Credentials;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author yujian    2020/05/21
 */
public class Hello_sol_hello extends Contract {
    private static final String BINARY = "60606040523415600e57600080fd5b609a8061001c6000396000f300606060405260043610603e5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663ab3ae25581146043575b600080fd5b3415604d57600080fd5b60566004356068565b60405190815260200160405180910390f35b600802905600a165627a7a723058200cc51f5dad45190b24189d9f8ff836d704bcebc9862cfd669e054b8c8f19f66c0029";

    protected Hello_sol_hello(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Hello_sol_hello(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> main(BigInteger a) {
        Function function = new Function("main",
                                         Arrays.<Type>asList(new com.em.sdk.abi.datatypes.generated.Uint256(a)),
                                         Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Hello_sol_hello> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Hello_sol_hello.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Hello_sol_hello> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Hello_sol_hello.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Hello_sol_hello load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Hello_sol_hello(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Hello_sol_hello load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Hello_sol_hello(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}

package com.em.sdk;

import com.em.sdk.abi.FunctionEncoder;
import com.em.sdk.abi.datatypes.Address;
import com.em.sdk.abi.datatypes.Function;
import com.em.sdk.abi.datatypes.generated.Uint256;
import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.DefaultBlockParameterName;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;
import com.em.sdk.core.protocol.http.HttpService;
import com.em.sdk.core.token.Hello_sol_hello;
import com.em.sdk.core.tx.ChainId;
import com.em.sdk.core.utils.EmGas;
import com.em.sdk.crypto.Credentials;
import com.em.sdk.crypto.RawTransaction;
import com.em.sdk.crypto.TransactionEncoder;
import com.em.sdk.utils.Convert;
import com.em.sdk.utils.Numeric;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yujian    2020/05/21
 */
public class ContractTests {

    private Web3j web3j;

    @Before
    public void init() {
        web3j = Web3j.build(new HttpService("http://172.16.20.76:8545"));
    }


    private final String testPrivateKey = "b968d08d67b3664bebd6b11b517557a29186e3c5f8474959d5db7cc0442b1831";
    private final String testAddress = "EM2e25d6f13330163134b9e321491ca0d45233e054";


    @Test
    public void deploySimpleContract() throws Exception {

        String ownAddress = "0xD1c82c71cC567d63Fd53D5B91dcAC6156E5B96B3";
        String toAddress = "0x6e27727bbb9f0140024a62822f013385f4194999";
        Credentials credentials = Credentials.create(testPrivateKey);
        BigInteger gasLimit = BigInteger.valueOf(186440);
        //部署智能合约
        Hello_sol_hello helloSol =
            Hello_sol_hello.deploy(web3j, credentials, EmGas.defaultGasPrice.toBigInteger(), gasLimit).send();
        System.out.println(helloSol.getContractAddress());
        //调用智能合约
        System.out.println(helloSol.main(new BigInteger("2")).send());

    }

    @Test
    public void callErc20Contract() throws Exception {
        String contractAddress = "EM39cd03c1021de42505d0d7acbcece7363afa3433";
        BigInteger gas = EmGas.defaultCallErc20Gas.toBigInteger();
        BigInteger gasPrice = EmGas.defaultGasPrice.toBigInteger();
        String to = "EM6e27727bbb9f0140024a62822f013385f4194999";
        Credentials credentials = Credentials.create(testPrivateKey);

        BigInteger nonce = web3j.emGetTransactionCount(testAddress, DefaultBlockParameterName.LATEST)
                                .sendAsync().get().getTransactionCount();
        BigInteger value = Convert.toWei("10", Convert.Unit.WEI).toBigInteger();

        Function function = new Function("transfer", Arrays.asList(new Address(to), new Uint256(value)), Collections
            .emptyList());
        String encodedFunction = FunctionEncoder.encode(function);

        RawTransaction rawTransaction = RawTransaction
            .createFunctionCallTransaction(nonce, gasPrice, gas, contractAddress, BigInteger.valueOf(0),
                                           encodedFunction);

        byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, ChainId.MAINNET, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        System.err.printf("sign Hex:%s\n", hexValue);
        EMSendTransaction emSendTransaction = web3j.emSendRawTransaction(hexValue).sendAsync().get();
        if (emSendTransaction.getError() != null) {
            System.err.printf("sendRawTransaction error:%s\n", emSendTransaction.getError().getMessage());
        } else {
            String transactionHash = emSendTransaction.getTransactionHash();
            System.err.printf("sendRawTransaction success,trxHash:%s\n", transactionHash);
        }

    }
}

package com.em.sdk.core.token;

// import io.reactivex.Flowable;
//import com.em.sdk.protocol.Web3j;
//
//import com.em.sdk.protocol.core.RemoteCall;
//import com.em.sdk.protocol.core.RemoteFunctionCall;
//import com.em.sdk.protocol.core.methods.request.EthFilter;
//import com.em.sdk.protocol.core.methods.response.BaseEventResponse;
//import com.em.sdk.protocol.core.methods.response.Log;
//import com.em.sdk.protocol.core.methods.response.TransactionReceipt;
//import com.em.sdk.tx.Contract;
//import com.em.sdk.tx.TransactionManager;
//import com.em.sdk.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the com.em.sdk.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
// public class Aoa extends Contract
public class Aoa  {
//    public static final String BINARY = "6060604052341561000f57600080fd5b6040516110053803806110058339810160405280805190602001909190805182019190602001805190602001909190805182019190505083600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508360008190555082600390805190602001906100a79291906100e3565b5081600460006101000a81548160ff021916908360ff16021790555080600590805190602001906100d99291906100e3565b5050505050610188565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061012457805160ff1916838001178555610152565b82800160010185558215610152579182015b82811115610151578251825591602001919060010190610136565b5b50905061015f9190610163565b5090565b61018591905b80821115610181576000816000905550600101610169565b5090565b90565b610e6e806101976000396000f3006060604052600436106100a4576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806306fdde03146100a9578063095ea7b31461013757806318160ddd1461019157806323b872dd146101ba578063313ce5671461023357806370a082311461026257806395d89b41146102af578063a9059cbb1461033d578063cae9ca5114610397578063dd62ed3e14610434575b600080fd5b34156100b457600080fd5b6100bc6104a0565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100fc5780820151818401526020810190506100e1565b50505050905090810190601f1680156101295780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561014257600080fd5b610177600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190505061053e565b604051808215151515815260200191505060405180910390f35b341561019c57600080fd5b6101a4610630565b6040518082815260200191505060405180910390f35b34156101c557600080fd5b610219600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610636565b604051808215151515815260200191505060405180910390f35b341561023e57600080fd5b6102466108b2565b604051808260ff1660ff16815260200191505060405180910390f35b341561026d57600080fd5b610299600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506108c5565b6040518082815260200191505060405180910390f35b34156102ba57600080fd5b6102c261090e565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156103025780820151818401526020810190506102e7565b50505050905090810190601f16801561032f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561034857600080fd5b61037d600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506109ac565b604051808215151515815260200191505060405180910390f35b34156103a257600080fd5b61041a600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610b15565b604051808215151515815260200191505060405180910390f35b341561043f57600080fd5b61048a600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610dbb565b6040518082815260200191505060405180910390f35b60038054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105365780601f1061050b57610100808354040283529160200191610536565b820191906000526020600020905b81548152906001019060200180831161051957829003601f168201915b505050505081565b600081600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925846040518082815260200191505060405180910390a36001905092915050565b60005481565b600081600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410158015610703575081600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410155b801561070f5750600082115b156108a65781600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254019250508190555081600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254039250508190555081600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825403925050819055508273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a3600190506108ab565b600090505b9392505050565b600460009054906101000a900460ff1681565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b60058054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109a45780601f10610979576101008083540402835291602001916109a4565b820191906000526020600020905b81548152906001019060200180831161098757829003601f168201915b505050505081565b600081600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054101580156109fd5750600082115b15610b0a5781600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254039250508190555081600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825401925050819055508273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040518082815260200191505060405180910390a360019050610b0f565b600090505b92915050565b600082600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508373ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925856040518082815260200191505060405180910390a38373ffffffffffffffffffffffffffffffffffffffff1660405180807f72656365697665417070726f76616c28616464726573732c75696e743235362c81526020017f616464726573732c627974657329000000000000000000000000000000000000815250602e01905060405180910390207c01000000000000000000000000000000000000000000000000000000009004338530866040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828051906020019080838360005b83811015610d56578082015181840152602081019050610d3b565b50505050905090810190601f168015610d835780820380516001836020036101000a031916815260200191505b5094505050505060006040518083038160008761646e5a03f1925050501515610daf5760009050610db4565b600190505b9392505050565b6000600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050929150505600a165627a7a72305820f4567a6299cd8e370c145f587ae2b9bc564137445f9f7ce69ba4bc75796cef9300290000000000000000000000000000000000000000204fce5e3e250261100000000000000000000000000000000000000000000000000000000000000000000080000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000c0000000000000000000000000000000000000000000000000000000000000000b4175726f7261436861696e0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003414f410000000000000000000000000000000000000000000000000000000000";
//
//    public static final String FUNC_NAME = "name";
//
//    public static final String FUNC_APPROVE = "approve";
//
//    public static final String FUNC_TOTALSUPPLY = "totalSupply";
//
//    public static final String FUNC_TRANSFERFROM = "transferFrom";
//
//    public static final String FUNC_DECIMALS = "decimals";
//
//    public static final String FUNC_BALANCEOF = "balanceOf";
//
//    public static final String FUNC_SYMBOL = "symbol";
//
//    public static final String FUNC_TRANSFER = "transfer";
//
//    public static final String FUNC_APPROVEANDCALL = "approveAndCall";
//
//    public static final String FUNC_ALLOWANCE = "allowance";
//
//    public static final Event TRANSFER_EVENT = new Event("Transfer",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
//    ;
//
//    public static final Event APPROVAL_EVENT = new Event("Approval",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
//    ;
//
//    @Deprecated
//    protected Aoa(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    protected Aoa(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    @Deprecated
//    protected Aoa(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    protected Aoa(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public RemoteFunctionCall<String> name() {
//        final Function function = new Function(FUNC_NAME,
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
//        return executeRemoteCallSingleValueReturn(function, String.class);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
//        final Function function = new Function(
//                FUNC_APPROVE,
//                Arrays.<Type>asList(new com.em.sdk.abi.datatypes.Address(160, _spender),
//                new com.em.sdk.abi.datatypes.generated.Uint256(_value)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<BigInteger> totalSupply() {
//        final Function function = new Function(FUNC_TOTALSUPPLY,
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
//        final Function function = new Function(
//                FUNC_TRANSFERFROM,
//                Arrays.<Type>asList(new com.em.sdk.abi.datatypes.Address(160, _from),
//                new com.em.sdk.abi.datatypes.Address(160, _to),
//                new com.em.sdk.abi.datatypes.generated.Uint256(_value)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<BigInteger> decimals() {
//        final Function function = new Function(FUNC_DECIMALS,
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    public RemoteFunctionCall<BigInteger> balanceOf(String _owner) {
//        final Function function = new Function(FUNC_BALANCEOF,
//                Arrays.<Type>asList(new com.em.sdk.abi.datatypes.Address(160, _owner)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    public RemoteFunctionCall<String> symbol() {
//        final Function function = new Function(FUNC_SYMBOL,
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
//        return executeRemoteCallSingleValueReturn(function, String.class);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
//        final Function function = new Function(
//                FUNC_TRANSFER,
//                Arrays.<Type>asList(new com.em.sdk.abi.datatypes.Address(160, _to),
//                new com.em.sdk.abi.datatypes.generated.Uint256(_value)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> approveAndCall(String _spender, BigInteger _value, byte[] _extraData) {
//        final Function function = new Function(
//                FUNC_APPROVEANDCALL,
//                Arrays.<Type>asList(new com.em.sdk.abi.datatypes.Address(160, _spender),
//                new com.em.sdk.abi.datatypes.generated.Uint256(_value),
//                new com.em.sdk.abi.datatypes.DynamicBytes(_extraData)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<BigInteger> allowance(String _owner, String _spender) {
//        final Function function = new Function(FUNC_ALLOWANCE,
//                Arrays.<Type>asList(new com.em.sdk.abi.datatypes.Address(160, _owner),
//                new com.em.sdk.abi.datatypes.Address(160, _spender)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
//        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            TransferEventResponse typedResponse = new TransferEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
//            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Flowable<TransferEventResponse> transferEventFlowable(EMFilter filter) {
//        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferEventResponse>() {
//            @Override
//            public TransferEventResponse apply(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
//                TransferEventResponse typedResponse = new TransferEventResponse();
//                typedResponse.log = log;
//                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
//                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
//                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//                return typedResponse;
//            }
//        });
//    }
//
//    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
//        return transferEventFlowable(filter);
//    }
//
//    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
//        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
//            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }
//
//    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
//        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalEventResponse>() {
//            @Override
//            public ApprovalEventResponse apply(Log log) {
//                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
//                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
//                typedResponse.log = log;
//                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
//                typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
//                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//                return typedResponse;
//            }
//        });
//    }
//
//    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
//        return approvalEventFlowable(filter);
//    }
//
//    @Deprecated
//    public static Aoa load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return new Aoa(contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    @Deprecated
//    public static Aoa load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return new Aoa(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    public static Aoa load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
//        return new Aoa(contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    public static Aoa load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return new Aoa(contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public static RemoteCall<Aoa> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new com.em.sdk.abi.datatypes.generated.Uint256(_initialAmount),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenName),
//                new com.em.sdk.abi.datatypes.generated.Uint8(_decimalUnits),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenSymbol)));
//        return deployRemoteCall(Aoa.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
//    }
//
//    public static RemoteCall<Aoa> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new com.em.sdk.abi.datatypes.generated.Uint256(_initialAmount),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenName),
//                new com.em.sdk.abi.datatypes.generated.Uint8(_decimalUnits),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenSymbol)));
//        return deployRemoteCall(Aoa.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
//    }
//
//    @Deprecated
//    public static RemoteCall<Aoa> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new com.em.sdk.abi.datatypes.generated.Uint256(_initialAmount),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenName),
//                new com.em.sdk.abi.datatypes.generated.Uint8(_decimalUnits),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenSymbol)));
//        return deployRemoteCall(Aoa.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
//    }
//
//    @Deprecated
//    public static RemoteCall<Aoa> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _initialAmount, String _tokenName, BigInteger _decimalUnits, String _tokenSymbol) {
//        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new com.em.sdk.abi.datatypes.generated.Uint256(_initialAmount),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenName),
//                new com.em.sdk.abi.datatypes.generated.Uint8(_decimalUnits),
//                new com.em.sdk.abi.datatypes.Utf8String(_tokenSymbol)));
//        return deployRemoteCall(Aoa.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
//    }
//
//    public static class TransferEventResponse extends BaseEventResponse {
//        public String _from;
//
//        public String _to;
//
//        public BigInteger _value;
//    }
//
//    public static class ApprovalEventResponse extends BaseEventResponse {
//        public String _owner;
//
//        public String _spender;
//
//        public BigInteger _value;
//    }
}

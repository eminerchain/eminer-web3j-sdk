package com.em.sdk.core.protocol.core;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.Web3jService;
import com.em.sdk.core.protocol.core.methods.request.ShhFilter;
import com.em.sdk.core.protocol.core.methods.request.ShhPost;
import com.em.sdk.core.protocol.core.methods.request.Transaction;
import com.em.sdk.core.protocol.core.methods.response.DbGetHex;
import com.em.sdk.core.protocol.core.methods.response.DbGetString;
import com.em.sdk.core.protocol.core.methods.response.DbPutHex;
import com.em.sdk.core.protocol.core.methods.response.DbPutString;
import com.em.sdk.core.protocol.core.methods.response.EMAccounts;
import com.em.sdk.core.protocol.core.methods.response.EMBlock;
import com.em.sdk.core.protocol.core.methods.response.EMBlockNumber;
import com.em.sdk.core.protocol.core.methods.response.EMCall;
import com.em.sdk.core.protocol.core.methods.response.EMCompileLLL;
import com.em.sdk.core.protocol.core.methods.response.EMCompileSerpent;
import com.em.sdk.core.protocol.core.methods.response.EMCompileSolidity;
import com.em.sdk.core.protocol.core.methods.response.EMEstimateGas;
import com.em.sdk.core.protocol.core.methods.response.EMFilter;
import com.em.sdk.core.protocol.core.methods.response.EMGasPrice;
import com.em.sdk.core.protocol.core.methods.response.EMGetBalance;
import com.em.sdk.core.protocol.core.methods.response.EMGetBlockTransactionCountByHash;
import com.em.sdk.core.protocol.core.methods.response.EMGetBlockTransactionCountByNumber;
import com.em.sdk.core.protocol.core.methods.response.EMGetCode;
import com.em.sdk.core.protocol.core.methods.response.EMGetCompilers;
import com.em.sdk.core.protocol.core.methods.response.EMGetDelegate;
import com.em.sdk.core.protocol.core.methods.response.EMGetDelegateList;
import com.em.sdk.core.protocol.core.methods.response.EMGetStorageAt;
import com.em.sdk.core.protocol.core.methods.response.EMGetTransactionCount;
import com.em.sdk.core.protocol.core.methods.response.EMGetTransactionCountIncludePending;
import com.em.sdk.core.protocol.core.methods.response.EMGetTransactionReceipt;
import com.em.sdk.core.protocol.core.methods.response.EMGetVotesNumber;
import com.em.sdk.core.protocol.core.methods.response.EMLog;
import com.em.sdk.core.protocol.core.methods.response.EMProtocolVersion;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;
import com.em.sdk.core.protocol.core.methods.response.EMSign;
import com.em.sdk.core.protocol.core.methods.response.EMSyncing;
import com.em.sdk.core.protocol.core.methods.response.EMTransaction;
import com.em.sdk.core.protocol.core.methods.response.EMUninstallFilter;
import com.em.sdk.core.protocol.core.methods.response.Log;
import com.em.sdk.core.protocol.core.methods.response.NetListening;
import com.em.sdk.core.protocol.core.methods.response.NetPeerCount;
import com.em.sdk.core.protocol.core.methods.response.NetVersion;
import com.em.sdk.core.protocol.core.methods.response.ShhAddToGroup;
import com.em.sdk.core.protocol.core.methods.response.ShhHasIdentity;
import com.em.sdk.core.protocol.core.methods.response.ShhMessages;
import com.em.sdk.core.protocol.core.methods.response.ShhNewFilter;
import com.em.sdk.core.protocol.core.methods.response.ShhNewGroup;
import com.em.sdk.core.protocol.core.methods.response.ShhNewIdentity;
import com.em.sdk.core.protocol.core.methods.response.ShhUninstallFilter;
import com.em.sdk.core.protocol.core.methods.response.ShhVersion;
import com.em.sdk.core.protocol.core.methods.response.Web3ClientVersion;
import com.em.sdk.core.protocol.core.methods.response.Web3Sha3;
import com.em.sdk.core.protocol.rx.JsonRpc2_0Rx;
import com.em.sdk.core.utils.Async;
import com.em.sdk.utils.Numeric;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

import rx.Observable;


/**
 * JSON-RPC 2.0 factory implementation.
 */
public class JsonRpc2_0Web3j implements Web3j {

    public static final int DEFAULT_BLOCK_TIME = 10 * 1000;

    protected final Web3jService web3jService;
    private final JsonRpc2_0Rx web3jRx;
    private final long blockTime;

    public JsonRpc2_0Web3j(Web3jService web3jService) {
        this(web3jService, DEFAULT_BLOCK_TIME, Async.defaultExecutorService());
    }

    public JsonRpc2_0Web3j(
            Web3jService web3jService, long pollingInterval,
            ScheduledExecutorService scheduledExecutorService) {
        this.web3jService = web3jService;
        this.web3jRx = new JsonRpc2_0Rx(this, scheduledExecutorService);
        this.blockTime = pollingInterval;
    }

    @Override
    public Request<?, Web3ClientVersion> web3ClientVersion() {
        return new Request<>(
                "web3_clientVersion",
                Collections.<String>emptyList(),
                web3jService,
                Web3ClientVersion.class);
    }

    @Override
    public Request<?, Web3Sha3> web3Sha3(String data) {
        return new Request<>(
                "web3_sha3",
                Collections.singletonList(data),
                web3jService,
                Web3Sha3.class);
    }

    @Override
    public Request<?, NetVersion> netVersion() {
        return new Request<>(
                "net_version",
                Collections.<String>emptyList(),
                web3jService,
                NetVersion.class);
    }

    @Override
    public Request<?, NetListening> netListening() {
        return new Request<>(
                "net_listening",
                Collections.<String>emptyList(),
                web3jService,
                NetListening.class);
    }

    @Override
    public Request<?, NetPeerCount> netPeerCount() {
        return new Request<>(
                "net_peerCount",
                Collections.<String>emptyList(),
                web3jService,
                NetPeerCount.class);
    }

    @Override
    public Request<?, EMProtocolVersion> emProtocolVersion() {
        return new Request<>(
                "em_protocolVersion",
                Collections.<String>emptyList(),
                web3jService,
                EMProtocolVersion.class);
    }

    @Override
    public Request<?, EMSyncing> emSyncing() {
        return new Request<>(
                "em_syncing",
                Collections.<String>emptyList(),
                web3jService,
                EMSyncing.class);
    }


    @Override
    public Request<?, EMGasPrice> emGasPrice() {
        return new Request<>(
                "em_gasPrice",
                Collections.<String>emptyList(),
                web3jService,
                EMGasPrice.class);
    }

    @Override
    public Request<?, EMAccounts> emAccounts() {
        return new Request<>(
                "em_accounts",
                Collections.<String>emptyList(),
                web3jService,
                EMAccounts.class);
    }

    @Override
    public Request<?, EMBlockNumber> emBlockNumber() {
        return new Request<>(
                "em_blockNumber",
                Collections.<String>emptyList(),
                web3jService,
                EMBlockNumber.class);
    }

    @Override
    public Request<?, EMGetVotesNumber> emGetVotesNumber(String address) {
        return new Request<>(
                "em_getVotesNumber",
                Collections.singletonList(address),
                web3jService,
                EMGetVotesNumber.class);
    }

    @Override
    public Request<?, EMGetDelegate> emGetDelegate(String address) {
        return new Request<>(
                "em_getDelegate",
                Collections.singletonList(address),
                web3jService,
                EMGetDelegate.class
        );
    }

    @Override
    public Request<?, EMGetDelegateList> emGetDelegateList() {
        return new Request<>(
                "em_getDelegateList",
                new ArrayList<>(),
                web3jService,
                EMGetDelegateList.class
        );
    }

    @Override
    public Request<?, EMGetBalance> emGetBalance(
            String address, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_getBalance",
                Arrays.asList(address, defaultBlockParameter.getValue()),
                web3jService,
                EMGetBalance.class);
    }

    @Override
    public Request<?, EMGetBalance> emGetAssetBalance(String address, String assetId, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_getAssetBalance",
                Arrays.asList(address, assetId, defaultBlockParameter.getValue()),
                web3jService,
                EMGetBalance.class);
    }

    @Override
    public Request<?, EMGetStorageAt> emGetStorageAt(
            String address, BigInteger position, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_getStorageAt",
                Arrays.asList(
                        address,
                        Numeric.encodeQuantity(position),
                        defaultBlockParameter.getValue()),
                web3jService,
                EMGetStorageAt.class);
    }

    @Override
    public Request<?, EMGetTransactionCount> emGetTransactionCount(
            String address, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_getTransactionCount",
                Arrays.asList(address, defaultBlockParameter.getValue()),
                web3jService,
                EMGetTransactionCount.class);
    }

    @Override
    public Request<?, EMGetTransactionCountIncludePending> emGetTransactionCountIncludePending(String address) {
        return new Request<>(
                "em_getTransactionCountIncludePending",
                Collections.singletonList(address),
                web3jService,
                EMGetTransactionCountIncludePending.class
        );
    }


    @Override
    public Request<?, EMGetBlockTransactionCountByHash> emGetBlockTransactionCountByHash(
            String blockHash) {
        return new Request<>(
                "em_getBlockTransactionCountByHash",
                Collections.singletonList(blockHash),
                web3jService,
                EMGetBlockTransactionCountByHash.class);
    }

    @Override
    public Request<?, EMGetBlockTransactionCountByNumber> emGetBlockTransactionCountByNumber(
            DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_getBlockTransactionCountByNumber",
                Collections.singletonList(defaultBlockParameter.getValue()),
                web3jService,
                EMGetBlockTransactionCountByNumber.class);
    }


    @Override
    public Request<?, EMGetCode> emGetCode(
            String address, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_getCode",
                Arrays.asList(address, defaultBlockParameter.getValue()),
                web3jService,
                EMGetCode.class);
    }

    @Override
    public Request<?, EMSign> emSign(String address, String sha3HashOfDataToSign) {
        return new Request<>(
                "em_sign",
                Arrays.asList(address, sha3HashOfDataToSign),
                web3jService,
                EMSign.class);
    }

    @Override
    public Request<?, EMSendTransaction>
    emSendTransaction(
            Transaction transaction) {
        return new Request<>(
                "em_sendTransaction",
                Collections.singletonList(transaction),
                web3jService,
                EMSendTransaction.class);
    }

    @Override
    public Request<?, EMSendTransaction>
    emSendRawTransaction(
            String signedTransactionData) {
        return new Request<>(
                "em_sendRawTransaction",
                Collections.singletonList(signedTransactionData),
                web3jService,
                EMSendTransaction.class);
    }

    @Override
    public Request<?, EMCall> emCall(
            Transaction transaction, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "em_call",
                Arrays.asList(transaction, defaultBlockParameter),
                web3jService,
                EMCall.class);
    }

    @Override
    public Request<?, EMEstimateGas> emEstimateGas(Transaction transaction) {
        return new Request<>(
                "em_estimateGas",
                Collections.singletonList(transaction),
                web3jService,
                EMEstimateGas.class);
    }

    @Override
    public Request<?, EMBlock> emGetBlockByHash(
            String blockHash, boolean returnFullTransactionObjects) {
        return new Request<>(
                "em_getBlockByHash",
                Arrays.asList(
                        blockHash,
                        returnFullTransactionObjects),
                web3jService,
                EMBlock.class);
    }

    @Override
    public Request<?, EMBlock> emGetBlockByNumber(
            DefaultBlockParameter defaultBlockParameter,
            boolean returnFullTransactionObjects) {
        return new Request<>(
                "em_getBlockByNumber",
                Arrays.asList(
                        defaultBlockParameter.getValue(),
                        returnFullTransactionObjects),
                web3jService,
                EMBlock.class);
    }

    @Override
    public Request<?, EMTransaction> emGetTransactionByHash(String transactionHash) {
        return new Request<>(
                "em_getTransactionByHash",
                Collections.singletonList(transactionHash),
                web3jService,
                EMTransaction.class);
    }

    @Override
    public Request<?, EMTransaction> emGetTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex) {
        return new Request<>(
                "em_getTransactionByBlockHashAndIndex",
                Arrays.asList(
                        blockHash,
                        Numeric.encodeQuantity(transactionIndex)),
                web3jService,
                EMTransaction.class);
    }

    @Override
    public Request<?, EMTransaction> emGetTransactionByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex) {
        return new Request<>(
                "em_getTransactionByBlockNumberAndIndex",
                Arrays.asList(
                        defaultBlockParameter.getValue(),
                        Numeric.encodeQuantity(transactionIndex)),
                web3jService,
                EMTransaction.class);
    }

    @Override
    public Request<?, EMGetTransactionReceipt> emGetTransactionReceipt(String transactionHash) {
        return new Request<>(
                "em_getTransactionReceipt",
                Collections.singletonList(transactionHash),
                web3jService,
                EMGetTransactionReceipt.class);
    }

    @Override
    public Request<?, EMGetCompilers> emGetCompilers() {
        return new Request<>(
                "em_getCompilers",
                Collections.<String>emptyList(),
                web3jService,
                EMGetCompilers.class);
    }

    @Override
    public Request<?, EMCompileLLL> emCompileLLL(String sourceCode) {
        return new Request<>(
                "em_compileLLL",
                Collections.singletonList(sourceCode),
                web3jService,
                EMCompileLLL.class);
    }

    @Override
    public Request<?, EMCompileSolidity> emCompileSolidity(String sourceCode) {
        return new Request<>(
                "em_compileSolidity",
                Collections.singletonList(sourceCode),
                web3jService,
                EMCompileSolidity.class);
    }

    @Override
    public Request<?, EMCompileSerpent> emCompileSerpent(String sourceCode) {
        return new Request<>(
                "em_compileSerpent",
                Collections.singletonList(sourceCode),
                web3jService,
                EMCompileSerpent.class);
    }

    @Override
    public Request<?, EMFilter> emNewFilter(
            com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter) {
        return new Request<>(
                "em_newFilter",
                Collections.singletonList(EMFilter),
                web3jService,
                com.em.sdk.core.protocol.core.methods.response.EMFilter.class);
    }

    @Override
    public Request<?, EMFilter> emNewBlockFilter() {
        return new Request<>(
                "em_newBlockFilter",
                Collections.<String>emptyList(),
                web3jService,
                EMFilter.class);
    }

    @Override
    public Request<?, EMFilter> emNewPendingTransactionFilter() {
        return new Request<>(
                "em_newPendingTransactionFilter",
                Collections.<String>emptyList(),
                web3jService,
                EMFilter.class);
    }

    @Override
    public Request<?, EMUninstallFilter> emUninstallFilter(BigInteger filterId) {
        return new Request<>(
                "em_uninstallFilter",
                Collections.singletonList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                EMUninstallFilter.class);
    }

    @Override
    public Request<?, EMLog> emGetFilterChanges(BigInteger filterId) {
        return new Request<>(
                "em_getFilterChanges",
                Collections.singletonList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                EMLog.class);
    }

    @Override
    public Request<?, EMLog> emGetFilterLogs(BigInteger filterId) {
        return new Request<>(
                "em_getFilterLogs",
                Collections.singletonList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                EMLog.class);
    }

    @Override
    public Request<?, EMLog> emGetLogs(
            com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter) {
        return new Request<>(
                "em_getLogs",
                Collections.singletonList(EMFilter),
                web3jService,
                EMLog.class);
    }

    @Override
    public Request<?, DbPutString> dbPutString(
            String databaseName, String keyName, String stringToStore) {
        return new Request<>(
                "db_putString",
                Arrays.asList(databaseName, keyName, stringToStore),
                web3jService,
                DbPutString.class);
    }

    @Override
    public Request<?, DbGetString> dbGetString(String databaseName, String keyName) {
        return new Request<>(
                "db_getString",
                Arrays.asList(databaseName, keyName),
                web3jService,
                DbGetString.class);
    }

    @Override
    public Request<?, DbPutHex> dbPutHex(String databaseName, String keyName, String dataToStore) {
        return new Request<>(
                "db_putHex",
                Arrays.asList(databaseName, keyName, dataToStore),
                web3jService,
                DbPutHex.class);
    }

    @Override
    public Request<?, DbGetHex> dbGetHex(String databaseName, String keyName) {
        return new Request<>(
                "db_getHex",
                Arrays.asList(databaseName, keyName),
                web3jService,
                DbGetHex.class);
    }

    @Override
    public Request<?, com.em.sdk.core.protocol.core.methods.response.ShhPost> shhPost(ShhPost shhPost) {
        return new Request<>(
                "shh_post",
                Collections.singletonList(shhPost),
                web3jService,
                com.em.sdk.core.protocol.core.methods.response.ShhPost.class);
    }

    @Override
    public Request<?, ShhVersion> shhVersion() {
        return new Request<>(
                "shh_version",
                Collections.<String>emptyList(),
                web3jService,
                ShhVersion.class);
    }

    @Override
    public Request<?, ShhNewIdentity> shhNewIdentity() {
        return new Request<>(
                "shh_newIdentity",
                Collections.<String>emptyList(),
                web3jService,
                ShhNewIdentity.class);
    }

    @Override
    public Request<?, ShhHasIdentity> shhHasIdentity(String identityAddress) {
        return new Request<>(
                "shh_hasIdentity",
                Collections.singletonList(identityAddress),
                web3jService,
                ShhHasIdentity.class);
    }

    @Override
    public Request<?, ShhNewGroup> shhNewGroup() {
        return new Request<>(
                "shh_newGroup",
                Collections.<String>emptyList(),
                web3jService,
                ShhNewGroup.class);
    }

    @Override
    public Request<?, ShhAddToGroup> shhAddToGroup(String identityAddress) {
        return new Request<>(
                "shh_addToGroup",
                Collections.singletonList(identityAddress),
                web3jService,
                ShhAddToGroup.class);
    }

    @Override
    public Request<?, ShhNewFilter> shhNewFilter(ShhFilter shhFilter) {
        return new Request<>(
                "shh_newFilter",
                Collections.singletonList(shhFilter),
                web3jService,
                ShhNewFilter.class);
    }

    @Override
    public Request<?, ShhUninstallFilter> shhUninstallFilter(BigInteger filterId) {
        return new Request<>(
                "shh_uninstallFilter",
                Collections.singletonList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                ShhUninstallFilter.class);
    }

    @Override
    public Request<?, ShhMessages> shhGetFilterChanges(BigInteger filterId) {
        return new Request<>(
                "shh_getFilterChanges",
                Collections.singletonList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                ShhMessages.class);
    }

    @Override
    public Request<?, ShhMessages> shhGetMessages(BigInteger filterId) {
        return new Request<>(
                "shh_getMessages",
                Collections.singletonList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                ShhMessages.class);
    }

    @Override
    public Observable<String> ethBlockHashObservable() {
        return web3jRx.ethBlockHashObservable(blockTime);
    }

    @Override
    public Observable<String> ethPendingTransactionHashObservable() {
        return web3jRx.ethPendingTransactionHashObservable(blockTime);
    }

    @Override
    public Observable<Log> ethLogObservable(
            com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter) {
        return web3jRx.ethLogObservable(EMFilter, blockTime);
    }

    @Override
    public Observable<com.em.sdk.core.protocol.core.methods.response.Transaction>
    transactionObservable() {
        return web3jRx.transactionObservable(blockTime);
    }

    @Override
    public Observable<com.em.sdk.core.protocol.core.methods.response.Transaction>
    pendingTransactionObservable() {
        return web3jRx.pendingTransactionObservable(blockTime);
    }

    @Override
    public Observable<EMBlock> blockObservable(boolean fullTransactionObjects) {
        return web3jRx.blockObservable(fullTransactionObjects, blockTime);
    }

    @Override
    public Observable<EMBlock> replayBlocksObservable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock,
            boolean fullTransactionObjects) {
        return web3jRx.replayBlocksObservable(startBlock, endBlock, fullTransactionObjects);
    }

    @Override
    public Observable<EMBlock> replayBlocksObservable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock,
            boolean fullTransactionObjects, boolean ascending) {
        return web3jRx.replayBlocksObservable(startBlock, endBlock,
                fullTransactionObjects, ascending);
    }

    @Override
    public Observable<com.em.sdk.core.protocol.core.methods.response.Transaction>
    replayTransactionsObservable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        return web3jRx.replayTransactionsObservable(startBlock, endBlock);
    }

    @Override
    public Observable<EMBlock> catchUpToLatestBlockObservable(
            DefaultBlockParameter startBlock, boolean fullTransactionObjects,
            Observable<EMBlock> onCompleteObservable) {
        return web3jRx.catchUpToLatestBlockObservable(
                startBlock, fullTransactionObjects, onCompleteObservable);
    }

    @Override
    public Observable<EMBlock> catchUpToLatestBlockObservable(
            DefaultBlockParameter startBlock, boolean fullTransactionObjects) {
        return web3jRx.catchUpToLatestBlockObservable(startBlock, fullTransactionObjects);
    }

    @Override
    public Observable<com.em.sdk.core.protocol.core.methods.response.Transaction>
    catchUpToLatestTransactionObservable(DefaultBlockParameter startBlock) {
        return web3jRx.catchUpToLatestTransactionObservable(startBlock);
    }

    @Override
    public Observable<EMBlock> catchUpToLatestAndSubscribeToNewBlocksObservable(
            DefaultBlockParameter startBlock, boolean fullTransactionObjects) {
        return web3jRx.catchUpToLatestAndSubscribeToNewBlocksObservable(
                startBlock, fullTransactionObjects, blockTime);
    }

    @Override
    public Observable<com.em.sdk.core.protocol.core.methods.response.Transaction>
    catchUpToLatestAndSubscribeToNewTransactionsObservable(
            DefaultBlockParameter startBlock) {
        return web3jRx.catchUpToLatestAndSubscribeToNewTransactionsObservable(
                startBlock, blockTime);
    }
}

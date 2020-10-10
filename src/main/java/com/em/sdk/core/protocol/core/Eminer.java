package com.em.sdk.core.protocol.core;


import com.em.sdk.core.protocol.core.methods.request.ShhFilter;
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

import java.math.BigInteger;

/**
 * Core Aurora JSON-RPC API.
 */
public interface Eminer {

    Request<?, Web3ClientVersion> web3ClientVersion();

    Request<?, Web3Sha3> web3Sha3(String data);

    Request<?, NetVersion> netVersion();

    Request<?, NetListening> netListening();

    Request<?, NetPeerCount> netPeerCount();

    Request<?, EMProtocolVersion> emProtocolVersion();

    Request<?, EMSyncing> emSyncing();

    Request<?, EMGasPrice> emGasPrice();

    Request<?, EMAccounts> emAccounts();

    Request<?, EMBlockNumber> emBlockNumber();

    Request<?, EMGetVotesNumber> emGetVotesNumber(String address);

    Request<?, EMGetDelegate> emGetDelegate(String address);

    Request<?, EMGetDelegateList> emGetDelegateList();

    Request<?, EMGetBalance> emGetBalance(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EMGetBalance> emGetAssetBalance(String address, String assetId,
                                               DefaultBlockParameter defaultBlockParameter);

    Request<?, EMGetStorageAt> emGetStorageAt(String address, BigInteger position,
                                              DefaultBlockParameter defaultBlockParameter);

    Request<?, EMGetTransactionCount> emGetTransactionCount(String address,
                                                            DefaultBlockParameter defaultBlockParameter);

    Request<?, EMGetTransactionCountIncludePending> emGetTransactionCountIncludePending(String address);

    Request<?, EMGetBlockTransactionCountByHash> emGetBlockTransactionCountByHash(String blockHash);

    Request<?, EMGetBlockTransactionCountByNumber> emGetBlockTransactionCountByNumber(
        DefaultBlockParameter defaultBlockParameter);

    Request<?, EMGetCode> emGetCode(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, EMSign> emSign(String address, String sha3HashOfDataToSign);

    Request<?, EMSendTransaction> emSendTransaction(
        com.em.sdk.core.protocol.core.methods.request.Transaction transaction);

    Request<?, EMSendTransaction> emSendRawTransaction(String signedTransactionData);

    Request<?, EMCall> emCall(com.em.sdk.core.protocol.core.methods.request.Transaction transaction,
                              DefaultBlockParameter defaultBlockParameter);

    Request<?, EMEstimateGas> emEstimateGas(com.em.sdk.core.protocol.core.methods.request.Transaction transaction);

    Request<?, EMBlock> emGetBlockByHash(String blockHash, boolean returnFullTransactionObjects);

    Request<?, EMBlock> emGetBlockByNumber(DefaultBlockParameter defaultBlockParameter,
                                           boolean returnFullTransactionObjects);

    Request<?, EMTransaction> emGetTransactionByHash(String transactionHash);

    Request<?, EMTransaction> emGetTransactionByBlockHashAndIndex(String blockHash, BigInteger transactionIndex);

    Request<?, EMTransaction> emGetTransactionByBlockNumberAndIndex(DefaultBlockParameter defaultBlockParameter,
                                                                    BigInteger transactionIndex);

    Request<?, EMGetTransactionReceipt> emGetTransactionReceipt(String transactionHash);

    Request<?, EMGetCompilers> emGetCompilers();

    Request<?, EMCompileLLL> emCompileLLL(String sourceCode);

    Request<?, EMCompileSolidity> emCompileSolidity(String sourceCode);

    Request<?, EMCompileSerpent> emCompileSerpent(String sourceCode);

    Request<?, EMFilter> emNewFilter(com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter);

    Request<?, EMFilter> emNewBlockFilter();

    Request<?, EMFilter> emNewPendingTransactionFilter();

    Request<?, EMUninstallFilter> emUninstallFilter(BigInteger filterId);

    Request<?, EMLog> emGetFilterChanges(BigInteger filterId);

    Request<?, EMLog> emGetFilterLogs(BigInteger filterId);

    Request<?, EMLog> emGetLogs(com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter);

    Request<?, DbPutString> dbPutString(String databaseName, String keyName, String stringToStore);

    Request<?, DbGetString> dbGetString(String databaseName, String keyName);

    Request<?, DbPutHex> dbPutHex(String databaseName, String keyName, String dataToStore);

    Request<?, DbGetHex> dbGetHex(String databaseName, String keyName);

    Request<?, com.em.sdk.core.protocol.core.methods.response.ShhPost> shhPost(
        com.em.sdk.core.protocol.core.methods.request.ShhPost shhPost);

    Request<?, ShhVersion> shhVersion();

    Request<?, ShhNewIdentity> shhNewIdentity();

    Request<?, ShhHasIdentity> shhHasIdentity(String identityAddress);

    Request<?, ShhNewGroup> shhNewGroup();

    Request<?, ShhAddToGroup> shhAddToGroup(String identityAddress);

    Request<?, ShhNewFilter> shhNewFilter(ShhFilter shhFilter);

    Request<?, ShhUninstallFilter> shhUninstallFilter(BigInteger filterId);

    Request<?, ShhMessages> shhGetFilterChanges(BigInteger filterId);

    Request<?, ShhMessages> shhGetMessages(BigInteger filterId);
}

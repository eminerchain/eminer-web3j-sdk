package com.em.sdk.core.protocol.core.filters;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.core.protocol.core.methods.response.EMFilter;
import com.em.sdk.core.protocol.core.methods.response.EMLog;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Handler for working with transaction filter requests.
 */
public class PendingTransactionFilter extends Filter<String> {

    public PendingTransactionFilter(Web3j web3j, Callback<String> callback) {
        super(web3j, callback);
    }

    @Override
    EMFilter sendRequest() throws IOException {
        return web3j.emNewPendingTransactionFilter().send();
    }

    @Override
    void process(List<EMLog.LogResult> logResults) {
        for (EMLog.LogResult logResult : logResults) {
            if (logResult instanceof EMLog.Hash) {
                String blockHash = ((EMLog.Hash) logResult).get();
                callback.onEvent(blockHash);
            } else {
                throw new FilterException(
                        "Unexpected result type: " + logResult.get() + ", required Hash");
            }
        }
    }

    /**
     * Since the pending transaction filter does not support historic filters,
     * the filterId is ignored and an empty optional is returned
     * @param filterId
     * Id of the filter for which the historic log should be retrieved
     * @return
     * Optional.empty()
     */
    @Override
    protected Optional<Request<?, EMLog>> getFilterLogs(BigInteger filterId) {
        return Optional.empty();
    }
}


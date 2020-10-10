package com.em.sdk.core.protocol.core.filters;

import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.core.protocol.core.methods.response.EMLog;
import com.em.sdk.core.protocol.core.methods.response.Log;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Log filter handler.
 */
public class LogFilter extends Filter<Log> {

    private final com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter;

    public LogFilter(
            Web3j web3j, Callback<Log> callback,
            com.em.sdk.core.protocol.core.methods.request.EMFilter EMFilter) {
        super(web3j, callback);
        this.EMFilter = EMFilter;
    }


    @Override
    com.em.sdk.core.protocol.core.methods.response.EMFilter sendRequest() throws IOException {
        return web3j.emNewFilter(EMFilter).send();
    }

    @Override
    void process(List<EMLog.LogResult> logResults) {
        for (EMLog.LogResult logResult : logResults) {
            if (logResult instanceof EMLog.LogObject) {
                Log log = ((EMLog.LogObject) logResult).get();
                callback.onEvent(log);
            } else {
                throw new FilterException(
                        "Unexpected result type: " + logResult.get() + " required LogObject");
            }
        }
    }

    @Override
    protected Optional<Request<?, EMLog>> getFilterLogs(BigInteger filterId) {
        return Optional.of(web3j.emGetFilterLogs(filterId));
    }
}

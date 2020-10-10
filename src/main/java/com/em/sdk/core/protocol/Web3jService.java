package com.em.sdk.core.protocol;

import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.core.protocol.core.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Services API.
 */
public interface Web3jService {
    <T extends Response> T send(
        Request request, Class<T> responseType) throws IOException;

    <T extends Response> CompletableFuture<T> sendAsync(
        Request request, Class<T> responseType);
}

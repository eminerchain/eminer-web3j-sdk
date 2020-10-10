package com.em.sdk.em;

import com.em.sdk.core.protocol.Web3jService;
import com.em.sdk.core.protocol.admin.JsonRpc2_0Admin;
import com.em.sdk.core.protocol.admin.methods.response.BooleanResponse;
import com.em.sdk.core.protocol.admin.methods.response.PersonalSign;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.em.response.PersonalEcRecover;
import com.em.sdk.em.response.PersonalImportRawKey;

import java.util.Arrays;

/**
 * JSON-RPC 2.0 factory implementation for Aoa.
 */
class JsonRpc2_0Em extends JsonRpc2_0Admin implements Em {

    public JsonRpc2_0Em(Web3jService web3jService) {
        super(web3jService);
    }
    
    @Override
    public Request<?, PersonalImportRawKey> personalImportRawKey(
            String keydata, String password) {
        return new Request<>(
                "personal_importRawKey",
                Arrays.asList(keydata, password),
                web3jService,
                PersonalImportRawKey.class);
    }

    @Override
    public Request<?, BooleanResponse> personalLockAccount(String accountId) {
        return new Request<>(
                "personal_lockAccount",
                Arrays.asList(accountId),
                web3jService,
                BooleanResponse.class);
    }

    @Override
    public Request<?, PersonalSign> personalSign(
            String message, String accountId, String password) {
        return new Request<>(
                "personal_sign",
                Arrays.asList(message,accountId,password),
                web3jService,
                PersonalSign.class);
    }

    @Override
    public Request<?, PersonalEcRecover> personalEcRecover(
            String hexMessage, String signedMessage) {
        return new Request<>(
                "personal_ecRecover",
                Arrays.asList(hexMessage,signedMessage),
                web3jService,
                PersonalEcRecover.class);
    } 
    
}

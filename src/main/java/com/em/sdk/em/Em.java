package com.em.sdk.em;


import com.em.sdk.core.protocol.Web3jService;
import com.em.sdk.core.protocol.admin.Admin;
import com.em.sdk.core.protocol.admin.methods.response.BooleanResponse;
import com.em.sdk.core.protocol.admin.methods.response.PersonalSign;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.em.response.PersonalEcRecover;
import com.em.sdk.em.response.PersonalImportRawKey;

/**
 * JSON-RPC Request object building factory for Aoa.
 */
public interface Em extends Admin {

    static Em build(Web3jService web3jService) {
        return new JsonRpc2_0Em(web3jService);
    }
        
    public Request<?, PersonalImportRawKey> personalImportRawKey(String keydata, String password);
    
    public Request<?, BooleanResponse> personalLockAccount(String accountId);
    
    public Request<?, PersonalSign> personalSign(String message, String accountId, String password);
    
    public Request<?, PersonalEcRecover> personalEcRecover(String message, String signiture);
    
}

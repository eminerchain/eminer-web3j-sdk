package com.em.sdk.core.protocol.admin;



import com.em.sdk.core.protocol.Web3j;
import com.em.sdk.core.protocol.Web3jService;
import com.em.sdk.core.protocol.admin.methods.response.NewAccountIdentifier;
import com.em.sdk.core.protocol.admin.methods.response.PersonalListAccounts;
import com.em.sdk.core.protocol.admin.methods.response.PersonalUnlockAccount;
import com.em.sdk.core.protocol.core.Request;
import com.em.sdk.core.protocol.core.methods.request.Transaction;
import com.em.sdk.core.protocol.core.methods.response.EMSendTransaction;

import java.math.BigInteger;

/**
 * JSON-RPC Request object building factory for common Parity and Aoa.
 */
public interface Admin extends Web3j {

    static Admin build(Web3jService web3jService) {
        return new JsonRpc2_0Admin(web3jService);
    }
    
    public Request<?, PersonalListAccounts> personalListAccounts();
    
    public Request<?, NewAccountIdentifier> personalNewAccount(String password);
    
    public Request<?, PersonalUnlockAccount> personalUnlockAccount(
        String address, String passphrase, BigInteger duration);

    public Request<?, PersonalUnlockAccount> personalUnlockAccount(
        String address, String passphrase);

    public Request<?, EMSendTransaction> personalSendTransaction(
        Transaction transaction, String password);

}   

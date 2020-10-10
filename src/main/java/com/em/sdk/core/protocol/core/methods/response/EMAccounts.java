package com.em.sdk.core.protocol.core.methods.response;



import com.em.sdk.core.protocol.core.Response;

import java.util.List;

/**
 * aoa_accounts.
 */
public class EMAccounts extends Response<List<String>> {
    public List<String> getAccounts() {
        return getResult();
    }
}

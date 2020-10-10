package com.em.sdk.em.response;


import com.em.sdk.core.protocol.core.Response;

/**
 * personal_importRawKey.
 */
public class PersonalImportRawKey extends Response<String> {
    public String getAccountId() {
        return getResult();
    }
}

package com.em.sdk.utils;

import com.em.sdk.crypto.Credentials;
import com.em.sdk.crypto.ECKeyPair;
import com.em.sdk.crypto.Keys;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yujian    2020/05/20
 */
public class AddressUtil {

    private static final Pattern pattern = Pattern.compile("(?i:^em|0x)[0-9a-f]{40}[0-9A-Za-z]{0,32}$");


    /**
     * 随机创建一个新地址
     * @return 带私钥等信息
     */
    public static Credentials createAddress()
        throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        return Credentials.create(ecKeyPair);
    }

    /**
     * 判断地址是否合法
     * @param address 带前缀的地址
     * @return 是否合法
     */
    public static boolean verifyAddress(String address) {
        Matcher matcher = pattern.matcher(address.toLowerCase());
        return matcher.find();
    }
}

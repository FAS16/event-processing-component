package com.nordea.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.nordea.util.ArrayUtil.concatByteArrays;

public final class CryptoUtil {

    private CryptoUtil() {}

    public static byte[] computeHash(byte[] message, byte[] salt) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest.digest(concatByteArrays(message, salt));

    }
}
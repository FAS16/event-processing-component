package com.nordea.util;

public final class ArrayUtil {

    private ArrayUtil() {}

    // https://stackoverflow.com/questions/10416259/fastest-possible-byte-array-concatenation-method
    public static byte[] concatByteArrays(byte[] b1, byte[] b2) {
        byte[] result = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, result, 0, b1.length);
        System.arraycopy(b2, 0, result, b1.length, b2.length);

        return result;
    }
}
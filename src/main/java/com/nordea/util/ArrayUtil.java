package com.nordea.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ArrayUtil {

    private ArrayUtil() {}

    // https://stackoverflow.com/questions/10416259/fastest-possible-byte-array-concatenation-method
    public static byte[] concatByteArrays(byte[] b1, byte[] b2) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(b1.length + b2.length); // specifying buffer capacity for better performance/memory consumption
        try {
            bos.write(b1);
            bos.write(b2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bos.toByteArray();
    }
}
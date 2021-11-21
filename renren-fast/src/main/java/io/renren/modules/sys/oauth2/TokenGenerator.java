package io.renren.modules.sys.oauth2;

import io.renren.common.exception.RRException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    public static final char[] HEX_CODE = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte b : data) {
            sb.append(HEX_CODE[b >> 4] & 0xF);
            sb.append(HEX_CODE[(b & 0xF)]);
        }
        return sb.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algo = MessageDigest.getInstance("MD5");
            algo.reset();
            algo.update(param.getBytes(StandardCharsets.UTF_8));
            byte[] messageDigest = algo.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new RRException("生成Token失败", e);
        }
    }
}

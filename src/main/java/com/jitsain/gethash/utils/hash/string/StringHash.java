package com.jitsain.gethash.utils.hash.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 获取字符串hash类
 * @author zhong
 * @date 2023-02-18 10:43
 */
public class StringHash {

    /**
     * 将bytes类型的数据转换为16进制的数据
     *
     * @param bytes bytes数据
     * @return 16进制数据
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xFF & aByte);
            if (hex.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }


    /**
     * 获取字符串的md5值
     *
     * @param s 字符串
     * @return 字符串md5值
     */
    public static String getStringMD5(String s) {
        return getStringHash(s, "MD5");
    }


    /**
     * 获取字符串的sha1值
     *
     * @param s 字符串
     * @return 字符串的sha1值
     */
    public static String getStringSHA1(String s) {
        return getStringHash(s, "SHA1");
    }


    /**
     * 获取字符串的sha256值
     *
     * @param s 字符串
     * @return 字符串sha256值
     */
    public static String getStringSHA256(String s) {
        return getStringHash(s, "SHA256");
    }


    /**
     * 获取字符串的sha512值
     *
     * @param s 字符串
     * @return 字符串sha512值
     */
    public static String getStringSHA512(String s) {
        return getStringHash(s, "SHA512");
    }


    /**
     * 获取字符串的指定hash值
     *
     * @param s      字符串
     * @param method hash算法
     * @return 字符串指定hash值
     */
    public static String getStringHash(String s, String method) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance(method);
            mDigest.update(s.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(s.hashCode());
        }
        return cacheKey;
    }

}

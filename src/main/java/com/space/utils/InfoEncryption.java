package com.space.utils;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/02/19
 */
public class InfoEncryption {
    /**
     * BASE64加密
     * @param password
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(String password) throws Exception{
        return new String(Base64.encodeBase64(password.getBytes()));
    }

    /**
     * BASE64解密
     * @param password
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String password) throws Exception {
        byte[] bytes = Base64.decodeBase64(password);
        String str = new String(bytes);
        return str;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(InfoEncryption.encryptBASE64("/tmp/test/test.sh"));
    }

}

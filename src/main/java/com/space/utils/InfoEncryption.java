package com.space.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
        return (new BASE64Encoder().encodeBuffer(password.getBytes()));
    }

    /**
     * BASE64解密
     * @param password
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String password) throws Exception {
        byte[] bytes = new BASE64Decoder().decodeBuffer(password);
        String str = new String(bytes);
        return str;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(InfoEncryption.encryptBASE64("/tmp/test/test.sh"));
    }

}

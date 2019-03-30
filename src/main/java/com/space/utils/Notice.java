package com.space.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.omg.CORBA.PUBLIC_MEMBER;

/**通知类*/
public class Notice {

    /** 短信发送 传入手机号和短信内容*/
    public int sendShortMessage(String phone,String smsText) throws Exception {
        int responseCode = 100;
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
            NameValuePair[] data = {
                    new NameValuePair("Uid", "本站用户名"),
                    new NameValuePair("Key", "接口安全秘钥"),
                    new NameValuePair("smsMob", phone),
                    new NameValuePair("smsText", smsText)};
            post.setRequestBody(data);
            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:" + statusCode);
            for (Header h : headers) {
                System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
            System.out.println(result); //打印返回消息状态
            post.releaseConnection();
        } catch (Exception e) {
            responseCode = -100;
        }
        return responseCode;
    }
}

package com.space.utils;

import com.space.service.impl.CommodityServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * 通知类
 */
public class Notice {

    private static Logger logger = LoggerFactory.getLogger(Notice.class);

//    /** 短信发送 传入手机号和短信内容*/
//    public int sendShortMessage(String phone,String smsText) throws Exception {
//        int responseCode = 100;
//        try {
//            HttpClient client = new HttpClient();
//            PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
//            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
//            NameValuePair[] data = {
//                    new NameValuePair("Uid", "本站用户名"),
//                    new NameValuePair("Key", "接口安全秘钥"),
//                    new NameValuePair("smsMob", phone),
//                    new NameValuePair("smsText", smsText)};
//            post.setRequestBody(data);
//            client.executeMethod(post);
//            Header[] headers = post.getResponseHeaders();
//            int statusCode = post.getStatusCode();
//            System.out.println("statusCode:" + statusCode);
//            for (Header h : headers) {
//                System.out.println(h.toString());
//            }
//            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//            System.out.println(result); //打印返回消息状态
//            post.releaseConnection();
//        } catch (Exception e) {
//            responseCode = -100;
//        }
//        return responseCode;
//    }

    /**
     * 发送短信
     * @param emailServer  服务器信息
     * @param phones 电话号码
     * @param msg 短信内容
     * @throws IOException
     */
    public void sendSMS(String emailServer, List<String> phones, String msg) throws IOException {
        try {
            logger.info("Notice|send warn sms to:" + phones);
            if (emailServer.equals("")) {
            }
            if (null != emailServer && !emailServer.equals("")) {
                HttpClientBuilder builder = HttpClientBuilder.create();
                CloseableHttpClient client = builder.build();

                logger.info("Notice|total phone number count:" + phones.size());
                for (String Phone : phones) {
                    String url = emailServer + "?_m=sms&_a=send&phone_no=" + Phone + "&content=" + msg + "&tpl_id=603&channel=6";
                    logger.info("Notice|send sms ,url: " + url);

                    HttpPost httpPost = new HttpPost(url);
                    StringEntity postEntity = new StringEntity(url.toString(), ContentType.create("application/x-www-form-urlencoded", "UTF-8"));
                    // 设置一些Http头信息
                    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    httpPost.addHeader("connection", "Keep-Alive");
                    //httpPost.addHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                    // 将发送内容填装
                    httpPost.setEntity(postEntity);
                    HttpResponse response = null;
                    response = client.execute(httpPost);

                    HttpEntity entity = response.getEntity();
                    if (entity == null) {
                        logger.error("Notice|send sms failed", "");
                    }
                    String result = EntityUtils.toString(entity, "UTF-8");

                    logger.info("Notice|send sms success,result:" + result);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        logger.info("Notice|sleep thread error,message:" + e.getMessage());
                    }
                }

                client.close();
                logger.info("Notice|send sms success");
            } else {
                logger.error("Notice|sendSMS", "Did not find sms server config");
            }
        } catch (Exception e) {
            logger.info("Notice|send sms error,messag:" + e.getMessage());
        }

    }
}

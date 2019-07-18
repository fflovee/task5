package com.jnshu.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendEmail {
    public static boolean send_common(String phoneNum, String code) throws IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/send";

        final String apiUser = "hp21310_test_XIlJ28";
        final String apiKey = "5XvR6DHgYZb3rCq1";
//        final String rcpt_to = phoneNum;

        String subject = "【修仙院注册验证码】";
        String html = "你的验证码为:" + code;

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", phoneNum));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            //响应正常
            System.out.println("响应正常");
            // 正常返回, 解析返回数据
            String str = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSONObject.parseObject(str);
            String result = jsonObject.getString("result");
            if("true".equals(result)){
                System.out.println("发送成功");
                httpPost.releaseConnection();
                return true;
            }else {
                System.out.println("发送失败");
                httpPost.releaseConnection();
                return false;
            }
        }
        // 关闭链接
        httpPost.releaseConnection();
        System.out.println("响应失败");
        return false;
    }

//    public static void main(String[] args) throws IOException {
//        String phoneNum = "59qq.com";
//        String code = NumRandom.randomNum();
//        if (SendEmail.send_common(phoneNum, code)) {
//            System.out.println("发送成功");
//        } else {
//            System.out.println("发送失败");
//        }
//    }
}
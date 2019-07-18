package com.jnshu.aliyun;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @ClassName QuerySendDetails
 * @Description TODO
 * @Author 59200
 * @Date 2019/7/10 0:21
 * @Version 1.0
 **/
public class QuerySendDetails {
    public static boolean sendSms(String phoneNum, String code) throws ClientException, ServerException {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIyIEx8awpw8uj", "xTpQ5QPP209RBYoUbYcneuVm9u8bJ3");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        System.out.println("电话号码为======>" + phoneNum);
        request.putQueryParameter("SignName", "修仙院");
        request.putQueryParameter("TemplateCode", "SMS_170181264");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        System.out.println("验证码为为=========>" + code);

//        try {
        CommonResponse response = client.getCommonResponse(request);
        String str = response.getData();
        JSONObject jsonObject;
        jsonObject = JSONObject.parseObject(str);
        String strCode = jsonObject.getString("Code");
        System.out.println("Code==>"+strCode);
        if ("OK".equals(strCode)) {
            return true;
        }
        return false;
        //System.out.println(response.getData());
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }

    }
}

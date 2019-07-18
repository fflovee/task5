package com.jnshu.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @ClassName FileUpload
 * @Description TODO
 * @Author 59200
 * @Date 2019/7/16 17:32
 * @Version 1.0
 **/
public class FileUpload {
    public static String aliOss(MultipartFile file) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIHTyN1sdWVshz";
        String accessKeySecret = "ELMAl0FGUAQuQHZWfG1EFgEw8eiTBD";


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        byte[] content = file.getBytes();

        String prefix = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")) + "_" + System.currentTimeMillis();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = prefix + suffix;
        ossClient.putObject("hp21310", fileName, new ByteArrayInputStream(content));

        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        // ssClient.putObject("hp21310", path, new File("D:\\Desktop\\20180312200640916.png"));

        // 关闭OSSClient。
        ossClient.shutdown();
        String picPath = "https://hp21310.oss-cn-shanghai.aliyuncs.com/" + fileName;
        System.out.println(picPath);
        return picPath;
    }
}

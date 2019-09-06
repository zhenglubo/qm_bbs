package com.bbs.uitls;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.oss.model.UploadFileRequest;
import com.bbs.config.OssConfig;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description: oss工具类
 * @author: zhenglubo
 * @create: 2019-09-04 17:22
 **/

@Component
public class OssUtil {

    @Autowired
    private OssConfig ossConfig;

    public String uploadFile(MultipartFile multipartFile,String type,String userId) {
        String accessKey = ossConfig.getAccessKey();
        String accessId = ossConfig.getAccessId();
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String filename = multipartFile.getOriginalFilename();
        String key = generatorKey(dateString,type,userId,multipartFile.getOriginalFilename());
        DefaultCredentialProvider provider = new DefaultCredentialProvider(accessId, accessKey);
        OSSClient ossClient = new OSSClient(endpoint, provider, null);
        if (!ossClient.doesBucketExist(bucket)) {
            ossClient.createBucket(bucket);
        }
        try {
            ossClient.putObject(bucket, key, multipartFile.getInputStream());
            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            //设置过期时间为10年
            URL url = ossClient.generatePresignedUrl(bucket, key, expiration);
            return url.toString();
        }catch (IOException e){
        }
        return null;
    }

    public String generatorKey(String ...value){
        StringBuilder builder = new StringBuilder();
        for (String str : value) {
            builder.append(str).append("/");
        }
        String key = builder.toString();
        return key.substring(0,key.lastIndexOf("/"));
    }
}

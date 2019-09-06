package com.bbs.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: oss配置类
 * @author: zhenglubo
 * @create: 2019-09-04 17:13
 **/

@Configuration
@ConfigurationProperties(prefix="aliyun.oss")
@Data
@NoArgsConstructor
public class OssConfig {

    private String accessId;
    private String accessKey;
    private String bucket;
    private String endpoint;
}

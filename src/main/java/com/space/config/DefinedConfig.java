package com.space.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
/*自定义配置文件*/
@Data
public   class DefinedConfig {

    @Value("${file.uploadPath}")
    private String uploadPath;

    @Value("${file.downLoadPath}")
    private String downLoadPath;
}

package com.space.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 通过`@Configuration`注解，让Spring来加载该类配置
 * 通过`@EnableSwagger2`注解来启用Swagger
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * createRestApi函数创建Docket的Bean
     * @return
     */
    @Bean("welcome")
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 指定模块区分
                .groupName("欢迎模块")
                // select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger-ui来展现
                .select()
                // 采用指定扫描的包路径来定义，Swagger2会扫描该包下所有Controller定义的API，并产生文档内容
                // 除了被@ApiIgnore指定的请求外
                .apis(RequestHandlerSelectors.basePackage("com.space.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * apiInfo创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这是一个Demo项目")
                .termsOfServiceUrl("http://localhost:9999/swagger-ui.html")
                .contact(new Contact("pross","https://pross.space",""))
                .version("1.0")
                .build();
    }
}

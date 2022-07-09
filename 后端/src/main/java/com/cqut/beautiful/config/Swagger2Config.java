package com.cqut.beautiful.config;

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

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cqut.beautiful.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //apiInfo指的是接口文档信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("美容预约APP后台api")
                .description("美容预约APP接口文档")
                .contact(new Contact("heyuanchun", "", "164241366@qq.com"))
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }
}

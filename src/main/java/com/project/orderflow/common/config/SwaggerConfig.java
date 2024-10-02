package com.project.orderflow.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo(){
        return new Info()
                .title("OrderFlow Swagger")
                .description("orderFlow REST API")
                .version("1.0.0");
    }

//    @Bean
//    public GroupedOpenApi apiGroup(){
//        return GroupedOpenApi.builder()
//                .group("OrderFlow API")
//                .pathsToMatch("/**") // 모든 경로 포함
//                .build();
//    }

}

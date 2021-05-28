package com.lima.accesspoint.swagger;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

	@Bean
	public Docket apiAdmin() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.lima.accesspoint")).paths(PathSelectors.ant("/apc/v1/*"))
				.build().apiInfo(ApiInformation());

	}

	private ApiInfo ApiInformation() {
		return new ApiInfoBuilder().title("Access Point").description("Access Point Control System API ")
				.version("1.0.0").license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Jr. Lima", "https://www.linkedin.com/in/jr-lima/", "tdlima.ti@gmail.com"))
				.build();
	}

}

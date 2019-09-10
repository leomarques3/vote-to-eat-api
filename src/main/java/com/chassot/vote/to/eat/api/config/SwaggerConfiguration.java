package com.chassot.vote.to.eat.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket swaggerVotingApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.groupName("Voting control API")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.chassot.vote.to.eat.api.controller"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Restaurant Voting App - REST API")
				.description("API to communicate between the react application and the database")
				.contact(new Contact("Leonardo Chassot", "https://github.com/leomarques3",
						"leonardo.c.marques3@gmail.com"))
				.version("1.0.0").build();
	}

}

package com.bookmarket.bookMarket.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2 //Indica que o spring ative o swagger presente na aplicação

/*
/indicando para o spring que vamos criar um bean
e que ele observar todos os métodos dessa classe
*/
class SwaggerConfig {

    @Bean //Feijão
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2) //Tipo de documentação
        .select() //Selecione
        .apis(RequestHandlerSelectors.basePackage("com.bookmarket.bookMarket.controller")) //Tipo de selector com package onde se encontra o os controllers
        .paths(PathSelectors.any()) //para selecionar todos os caminhos (any = qualquer)
        .build() //Retorna um docket

        //Para mudar o nome a descrição da documentação
        .apiInfo(
            ApiInfoBuilder()
                .title("Book Market")
                .description("Book Market API")
                .build()
        )
}
package com.bookmarket.bookMarket.model.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

//Para fazer um dto:
data class PostCustomerRequestDto(
    @field: NotEmpty(message = "Error, missing field") //Validação para o campo não ser vazio
    val name: String, //Atributo que está sendo validado

    @field: Email(message = "This email is not valid") //Email que esta sendo validado
    val email: String //Atributo que está sendo validado
)
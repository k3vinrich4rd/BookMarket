package com.bookmarket.bookMarket.model.dto.request

import validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

//Para fazer um dto:
data class PostCustomerRequestDto(

    @field: NotBlank(message = "Error, missing field") //Valida��o para o campo n�o ser vazio
    val name: String, //Atributo que est� sendo validado

    @field: Email(message = "This email is not valid") //Email que esta sendo validado
    @EmailAvailable
    val email: String //Atributo que est� sendo validado
)
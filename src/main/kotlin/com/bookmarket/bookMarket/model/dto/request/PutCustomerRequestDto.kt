package com.bookmarket.bookMarket.model.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

//Para fazer um dto:
data class PutCustomerRequestDto(
    @field: NotBlank(message = "Error, missing field") //Valida??o para o campo n?o ser vazio
    val name: String, //Atributo que est? sendo validado

    @field: Email(message = "This email is not valid") //Email que esta sendo validado
    val email: String //Atributo que est? sendo validado
)

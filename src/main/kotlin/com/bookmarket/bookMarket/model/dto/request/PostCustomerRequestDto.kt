package com.bookmarket.bookMarket.model.dto.request

import com.bookmarket.bookMarket.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

//Para fazer um dto:
data class PostCustomerRequestDto(

    @field: NotBlank(message = "Error, missing field") //Validação para o campo não ser vazio
    val name: String, //Atributo que está sendo validado

    @field: Email(message = "This email is not valid") //Email que esta sendo validado
    @EmailAvailable
    val email: String, //Atributo que está sendo validado

    @field:NotBlank(message = "The password must be informed")
    var password: String //Atributo que está sendo validado (Spring security)
)
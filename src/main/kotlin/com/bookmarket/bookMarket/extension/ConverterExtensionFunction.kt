package com.bookmarket.bookMarket.extension

import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.model.dto.PostCustomerRequestDto
import com.bookmarket.bookMarket.model.dto.PutCustomerRequestDto

/*
Fun��o de extens�o do conversor:
Vantagens: Mais liberdade na reutiliza��o das fun��es
e mais liberdade para aplicar essas fun��es
*/

fun PostCustomerRequestDto.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequestDto.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
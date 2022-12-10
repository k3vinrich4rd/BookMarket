package com.bookmarket.bookMarket.extension

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.model.dto.request.PostBookRequestDto
import com.bookmarket.bookMarket.model.dto.request.PostCustomerRequestDto
import com.bookmarket.bookMarket.model.dto.request.PutBookRequestDto
import com.bookmarket.bookMarket.model.dto.request.PutCustomerRequestDto

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

fun PostBookRequestDto.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE, //Setando o status do livro
        customer = customer
    )
}

fun PutBookRequestDto.toBookModel(previusValue: BookModel): BookModel {

    return BookModel(
        id = previusValue.id,
        name = this.name ?: previusValue.name, // Se this.name for nulo, retorne o valor antigo (previousValue.name) se n�o pega o valor de name
        price = this.price ?: previusValue.price, //'?:' - Elvis operator
        status = previusValue.status, //Continuar�o com os valores antigos
        customer = previusValue.customer //Continuar�o com os valores antigos



    )
}


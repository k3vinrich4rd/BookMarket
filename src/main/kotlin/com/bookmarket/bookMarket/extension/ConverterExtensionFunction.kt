package com.bookmarket.bookMarket.extension

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.enums.CustomerStatus
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.model.dto.request.PostBookRequestDto
import com.bookmarket.bookMarket.model.dto.request.PostCustomerRequestDto
import com.bookmarket.bookMarket.model.dto.request.PutBookRequestDto
import com.bookmarket.bookMarket.model.dto.request.PutCustomerRequestDto

/*
Função de extensão do conversor:
Vantagens: Mais liberdade na reutilização das funções
e mais liberdade para aplicar essas funções
*/

fun PostCustomerRequestDto.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE //Setando o status de customer ao ser criado
    )
}

fun PutCustomerRequestDto.toCustomerModel(previusValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previusValue.id, //valor antigo (sem mudança)
        name = this.name ?: previusValue.name,
        email = this.email ?: previusValue.email,
        status = previusValue.status //Valor antigo (sem mudança)
    )
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
        name = this.name ?: previusValue.name, // Se this.name for nulo, retorne o valor antigo (previousValue.name) se não pega o valor de name
        price = this.price ?: previusValue.price, //'?:' - Elvis operator
        status = previusValue.status, //Continuarão com os valores antigos
        customer = previusValue.customer //Continuarão com os valores antigos
    )
}


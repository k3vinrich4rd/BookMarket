package com.bookmarket.bookMarket.controller.mapper

import com.bookmarket.bookMarket.model.PurchaseModel
import com.bookmarket.bookMarket.model.dto.request.PostPurchaseRequestDto
import com.bookmarket.bookMarket.service.BookService
import com.bookmarket.bookMarket.service.CustomerService
import org.springframework.stereotype.Component

@Component //Para o spring tomar conta
class PurchaseMapper( //Tira a necessidade de fazer injeções de dependência como foram feitas na classe bookController
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequestDto): PurchaseModel {
        val customer = customerService.readCustomerViaId(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)
        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price },//Somar todos os valores de price e colocar na variável
        )
    }
}
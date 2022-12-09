package com.bookmarket.bookMarket.controller

import com.bookmarket.bookMarket.extension.toBookModel
import com.bookmarket.bookMarket.model.dto.request.PostBookRequestDto
import com.bookmarket.bookMarket.service.BookService
import com.bookmarket.bookMarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    /*Explicação:
    /Recebe a request do tipo PostBookRequestDto
     pegando também por id do customer (variável) e
    seta o seu valor dentro do book(do tipo request)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody request: PostBookRequestDto) {
        val readCustomerViaId = customerService.readCustomerViaId(request.customerId)
        bookService.createBook(request.toBookModel(readCustomerViaId))

    }
}
package com.bookmarket.bookMarket.controller

import com.bookmarket.bookMarket.extension.toBookModel
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.dto.request.PostBookRequestDto
import com.bookmarket.bookMarket.service.BookService
import com.bookmarket.bookMarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
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
        val customer = customerService.readCustomerViaId(request.customerId)
        bookService.createBook(request.toBookModel(customer))

    }

    @GetMapping
    fun readBook(): List<BookModel> {
        return bookService.readBook()
    }

    @GetMapping("/{id}")
    fun readBookViaId(@PathVariable id: Int): BookModel =
        bookService.readBookViaId(id)

    @GetMapping("/active")
    //localhost:8080/books/active?=active (Pra efetuar a busca)
    fun findBookActives(): List<BookModel> =
        bookService.findByActives()

    /*
    (Outra forma de se declarar)
       @GetMapping("/active")
    fun findBookActives(): List<BookModel> {
        return bookService.findByActives()
    }
     */

//    @DeleteMapping("/{id}")
//    fun deleteBook(@PathVariable id: Int) =
//        customerService.deleteBook()
//





















//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun updateBook(@PathVariable id: Int, @RequestBody book: PutBookRequestDto) {
//        bookService.bookUpdate(book.toBookModel(id))
//    }
}
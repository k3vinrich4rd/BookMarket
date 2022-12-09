package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository //Inje��o de depend�ncia
) {
    fun createBook(bookModel: BookModel) {
        bookRepository.save(bookModel)
    }

}

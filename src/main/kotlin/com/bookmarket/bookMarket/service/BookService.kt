package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository //Injeção de dependência
) {
    fun createBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun readBook(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun readBookViaId(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun findByActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE)
    }


    fun deleteBook(id: Int) {
        //Mudando o status de um book através do delete
        val readBookViaId = readBookViaId(id)
        readBookViaId.status = BookStatus.ACTIVE
        bookUpdate(readBookViaId)
    }

    //Outra forma de se fazer (linha de expressão):
    fun bookUpdate(book: BookModel) =
        bookRepository.save(book)

}

package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.exception.NotFoundException
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository //Injeção de dependência
) {
    fun createBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun readBook(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun readBookViaId(id: Int): BookModel {                            //ML-001 é um erro da aplicação em si
        return bookRepository.findById(id).orElseThrow { NotFoundException("Book [$id] not exists", "ML-0001") }
                                                                                     //Argumentos da classe
    }

    fun findByActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
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

    fun deleteByCustomer(readCustomerViaId: CustomerModel) {
        // Ao pegar o id de um customer que está Inativado, ele deleta o livro relacionado a esse customer
        //Recebendo um customer por parâmetro e seus valores
        val books =
            bookRepository.findByCustomer(readCustomerViaId) //Buscando no banco de dados todos os livros pertencentes ao customer
        //E salvando na lista de livros (books)
        //For para interagir e mudar os status dos livros de acordo com status do customer
        for (book in books) {//iterando pela lista
            //Alterando o status de cada livro desta lista para deletado
            book.status = BookStatus.DELETED
        }
        bookRepository.saveAll(books) //Nos permite passar uma lista de livros e assim salvar todos de uma vez

    }

}

package com.bookmarket.bookMarket.controller

import com.bookmarket.bookMarket.extension.toBookModel
import com.bookmarket.bookMarket.extension.toBookResponse
import com.bookmarket.bookMarket.model.dto.request.PostBookRequestDto
import com.bookmarket.bookMarket.model.dto.request.PutBookRequestDto
import com.bookmarket.bookMarket.model.dto.response.BookResponse
import com.bookmarket.bookMarket.service.BookService
import com.bookmarket.bookMarket.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService, //Injeção de dependência
    val customerService: CustomerService //Injeção de dependência
) {

    /*Explicação:
    /Recebe a request do tipo PostBookRequestDto
     pegando também por id do customer (variável) e
    seta o seu valor dentro do book(do tipo request)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Resposta da entidade
    //Para pegar o customer e seus valores através do Id
    //E relacionar esses mesmo valores a um book cadastrado no sistema
    fun createBook(@RequestBody @Valid request: PostBookRequestDto) {
        val customer = customerService.readCustomerViaId(request.customerId)
        bookService.createBook(request.toBookModel(customer))

    }

    @GetMapping
    //inserindo paginação

    fun readBook(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.readBook(pageable).map { it.toBookResponse() }
        //Map., itera sobre todos os registros da lista, fazendo a transformação informada na chaves
    }

    @GetMapping("/{id}")
    fun readBookViaId(@PathVariable id: Int): BookResponse =
        bookService.readBookViaId(id).toBookResponse()

    @GetMapping("/active")
    //localhost:8080/books/active?=active (Pra efetuar a busca)
    fun findBookActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> =
        bookService.findByActives(pageable).map { it.toBookResponse() }


    /*
    (Outra forma de se declarar)
       @GetMapping("/active")
    fun findBookActives(): List<BookModel> {
        return bookService.findByActives()
    }
*/

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@PathVariable id: Int, @RequestBody book: PutBookRequestDto) {
        val bookSaved = bookService.readBookViaId(id) //vai pegar um registro já salvo
        bookService.bookUpdate(book.toBookModel(bookSaved)) //E vai atualizar esse mesmo registro
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) =
        bookService.deleteBook(id)


}

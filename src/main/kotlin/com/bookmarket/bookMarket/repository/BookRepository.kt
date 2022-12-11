package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<BookModel, Int> {
    //Query method e paginação:
    fun findByStatus(bookStatus: BookStatus, pageable: Pageable): Page<BookModel>

    //Query method:
    fun findByCustomer(customerModel: CustomerModel): List<BookModel>

    //override fun findAll(pageable: Pageable): Page<BookModel>

}

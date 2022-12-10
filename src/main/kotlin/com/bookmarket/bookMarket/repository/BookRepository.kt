package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<BookModel, Int> {
    //Query method:
    fun findByStatus(bookStatus: BookStatus): List<BookModel>

    //Query method:
    fun findByCustomer(customerModel: CustomerModel): List<BookModel>


}

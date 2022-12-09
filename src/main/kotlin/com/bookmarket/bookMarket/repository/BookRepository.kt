package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {

}

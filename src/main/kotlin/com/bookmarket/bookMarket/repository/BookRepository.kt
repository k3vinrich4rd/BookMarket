package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.model.BookModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<BookModel, Int> {

}

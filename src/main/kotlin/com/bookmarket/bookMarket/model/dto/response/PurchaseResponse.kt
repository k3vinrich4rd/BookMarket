package com.bookmarket.bookMarket.model.dto.response

import com.bookmarket.bookMarket.model.BookModel
import com.bookmarket.bookMarket.model.CustomerModel
import java.math.BigDecimal
import java.time.LocalDateTime

data class PurchaseResponse(

    var id: Int? = null,
    val customer: CustomerModel,
    val books: MutableList<BookModel>,
    val nfe: String? = null, //Nota fiscal eletrônica
    val price: BigDecimal,
    val createdAt: LocalDateTime
)


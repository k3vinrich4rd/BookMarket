package com.bookmarket.bookMarket.model.dto.response

import com.bookmarket.bookMarket.enums.BookStatus
import com.bookmarket.bookMarket.model.CustomerModel
import java.math.BigDecimal

data class BookResponse(

    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null


)
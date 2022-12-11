package com.bookmarket.bookMarket.model.dto.response

import com.bookmarket.bookMarket.enums.CustomerStatus

data class CustomerResponse(

    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)



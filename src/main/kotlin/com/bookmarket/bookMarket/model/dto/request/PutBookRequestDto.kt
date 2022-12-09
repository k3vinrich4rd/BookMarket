package com.bookmarket.bookMarket.model.dto.request

import java.math.BigDecimal

data class PutBookRequestDto(
    var name: String,
    var price: BigDecimal,
    var id: Int


)

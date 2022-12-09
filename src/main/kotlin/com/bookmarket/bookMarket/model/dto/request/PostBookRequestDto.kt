package com.bookmarket.bookMarket.model.dto.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequestDto(
    var name: String,
    var price: BigDecimal,

    @JsonAlias("Customer_id") //Para transformar o nome da variável em snake case
    //Colocando o valor do campo dentro de uma variável
    var customerId: Int
)



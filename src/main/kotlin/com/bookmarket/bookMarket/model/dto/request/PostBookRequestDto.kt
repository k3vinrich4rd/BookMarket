package com.bookmarket.bookMarket.model.dto.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty

data class PostBookRequestDto(

    @field: NotEmpty(message = "Error, missing field") //Validação para o campo não ser vazio
    var name: String,

    @field: NotEmpty(message = "Error, missing field") //Validação para o campo não ser vazio
    var price: BigDecimal,

    @JsonAlias("customer_id") //Para transformar o nome da variável em snake case
    //E assim colocando o valor do campo dentro de uma variável
    var customerId: Int
)



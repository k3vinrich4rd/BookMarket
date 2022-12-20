package com.bookmarket.bookMarket.model.dto.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PostBookRequestDto(

    @field: NotBlank(message = "Error, missing field") //Validação para o campo não ser vazio
    var name: String,

    @field: NotNull(message = "Error, missing field") //Validação para o campo não ser vazio
    var price: BigDecimal,

    @JsonAlias("customer_id") //Para transformar o nome da variável em snake case
    //E assim colocando o valor do campo dentro de uma variável
    var customerId: Int
)



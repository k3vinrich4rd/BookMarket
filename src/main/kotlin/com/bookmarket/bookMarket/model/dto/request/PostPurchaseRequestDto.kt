package com.bookmarket.bookMarket.model.dto.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequestDto(
    @field: NotNull //Para o campo n�o ser n�o nulo
    @field: Positive // Para o n�mero informado no campo n�o ser menor que 1
    @JsonAlias("customer_id")
    val customerId: Int, //Para pegar o id dos clientes que v�o comprar os livros


    @field: NotNull //Para o campo n�o ser n�o nulo
    //Para pegar o id dos livros comprados pelo customer
    @JsonAlias("book_ids")
    val bookIds: Set<Int> //Um set porque ele recebe valores diferentes
)

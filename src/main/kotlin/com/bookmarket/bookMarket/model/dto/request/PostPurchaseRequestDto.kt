package com.bookmarket.bookMarket.model.dto.request

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequestDto(
    @field: NotNull //Para o campo não ser não nulo
    @field: Positive // Para o número informado no campo não ser menor que 1
    val customerId: Int, //Para pegar o id dos clientes que vão comprar os livros


    @field: NotNull //Para o campo não ser não nulo
    //Para pegar o id dos livros comprados pelo customer
    val bookIds: Set<Int> //Um set porque ele recebe valores diferentes
)

package com.bookmarket.bookMarket.model.dto.request

import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/*
/S� foi informado esses dois atributos, porque eu quero
que o usu�rio s� tenha a possibilidade de mudar os dois campos informados
 */
data class PutBookRequestDto(
    var name: String?,
    var price: BigDecimal?

)

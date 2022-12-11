package com.bookmarket.bookMarket.model.dto.response

data class ErrorResponse(
    var httpCode: Int, //C�digo http do erro
    var message: String, //Mensagem
    var internalCode: String, //C�digo interno
    var errors: List<FieldErrorResponse>? //resposta de erro de campo

)

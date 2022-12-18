package com.bookmarket.bookMarket.model.dto.response

//Resposta de erros
data class ErrorResponse(
    var httpCode: Int, //Código http do erro
    var message: String, //Mensagem
    var internalCode: String, //Código interno
    var errors: List<FieldErrorResponse>? //resposta de erro de campo

)

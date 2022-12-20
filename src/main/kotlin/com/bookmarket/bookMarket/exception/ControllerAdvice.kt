package com.bookmarket.bookMarket.exception

import com.bookmarket.bookMarket.enums.Erros
import com.bookmarket.bookMarket.model.dto.response.ErrorResponse
import com.bookmarket.bookMarket.model.dto.response.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

//Controle de avisos
@ControllerAdvice //Responsável por cuidar de todos os erros que a aplicação retorna
class ControllerAdvice {

    //Tratamento para valores não encontrados(404)
    //Aqui conseguimos definir as configurações necessárias para fazer o tratamento de err
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.NOT_FOUND.value(), //404
            ex.message, //Este recurso não existe
            ex.errorCode, //Erro interno criado para aplicação
            null //Campo de erro
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

    //Tratamento para erros de requisição(400)
    //Aqui conseguimos definir as configurações necessárias para fazer o tratamento de erro
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(), //400
            ex.message, //Este recurso não existe
            ex.errorCode, //Erro interno criado para aplicação
            null //Campo do erro
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)

    }


    //Tratamento para erros de requisição(400)
    //Aqui conseguimos definir as configurações necessárias para fazer o tratamento de erro
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(), //400
            Erros.ML001.message, //Este recurso não existe
            Erros.ML001.code, //Enum
            //Pegamos a exception e fazemos um map. Para transformar os erros numa estrutura que é legível
            ex.bindingResult.fieldErrors.map { FieldErrorResponse(it.defaultMessage ?: "invalid", it.field) }
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST) //422

    }

}

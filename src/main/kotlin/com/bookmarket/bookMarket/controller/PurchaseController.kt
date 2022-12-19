package com.bookmarket.bookMarket.controller

import com.bookmarket.bookMarket.model.dto.request.PostPurchaseRequestDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController("/purchase")
//Controlador de compras
class PurchaseController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Valid request: PostPurchaseRequestDto) {

    }

}
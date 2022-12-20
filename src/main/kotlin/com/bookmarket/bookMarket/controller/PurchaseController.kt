package com.bookmarket.bookMarket.controller

import com.bookmarket.bookMarket.controller.mapper.PurchaseMapper
import com.bookmarket.bookMarket.extension.toPurchaseResponse
import com.bookmarket.bookMarket.model.dto.request.PostPurchaseRequestDto
import com.bookmarket.bookMarket.model.dto.response.PurchaseResponse
import com.bookmarket.bookMarket.service.PurchaseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("purchase")
//Controlador de compras
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Valid request: PostPurchaseRequestDto) {
        purchaseService.create(purchaseMapper.toModel(request))

    }

    @GetMapping
    //inserindo paginação
    //localhost:8080/purchase?size=2&page=3 (para efetuar a busca)
    fun readPurchase(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<PurchaseResponse> {
        return purchaseService.readPurchase(pageable).map { it.toPurchaseResponse() }
    }

    @GetMapping("/{id}")
    fun readPurchaseViaId(@PathVariable id: Int): PurchaseResponse {
        return purchaseService.readPurchaseViaId(id).toPurchaseResponse()
    }


}
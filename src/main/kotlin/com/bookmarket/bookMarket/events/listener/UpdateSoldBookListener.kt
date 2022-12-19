package com.bookmarket.bookMarket.events.listener

import com.bookmarket.bookMarket.events.PurchaseEvent
import com.bookmarket.bookMarket.service.BookService
import com.bookmarket.bookMarket.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component //Para o spring cuidar dessa classe
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) { //Toda a vez que disparar um evento esse ponto vai ser chamado
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}
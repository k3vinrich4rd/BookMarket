package com.bookmarket.bookMarket.events.listener

import com.bookmarket.bookMarket.events.PurchaseEvent
import com.bookmarket.bookMarket.service.BookService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component //Para o spring cuidar dessa classe
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @Async //Para deixar o evento Assíncrono
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) { //Toda a vez que disparar um evento esse ponto vai ser chamado
        println("Atualizando status dos livros")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}
package com.bookmarket.bookMarket.events.listener

import com.bookmarket.bookMarket.events.PurchaseEvent
import com.bookmarket.bookMarket.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID

@Component //Para o spring cuidar dessa classe
class GeneratedNfeLister(
    private val purchaseService: PurchaseService
) {

    @Async //Para deixar o evento Assíncrono
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) { //Toda a vez que disparar um evento esse ponto vai ser chamado
        println("Gerando nfe")
        val nfe = UUID.randomUUID().toString()
        //Preenchimento do campo nfe através dessa cópia:
        val purchaseModel = purchaseEvent.purchaseModel.copy(nfe = nfe)
        purchaseService.update(purchaseModel)
    }
}
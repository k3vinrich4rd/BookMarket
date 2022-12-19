package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.events.PurchaseEvent
import com.bookmarket.bookMarket.model.PurchaseModel
import com.bookmarket.bookMarket.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaserRepository: PurchaseRepository,
    //Serve para disparar um evento
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaserRepository.save(purchaseModel)

        //Evento.
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
        // this = quem está disparando o evento

    }

    fun update(purchaseModel: PurchaseModel) {
        purchaserRepository.save(purchaseModel)
    }
}

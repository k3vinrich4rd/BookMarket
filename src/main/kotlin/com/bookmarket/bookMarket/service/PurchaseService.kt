package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.enums.Erros
import com.bookmarket.bookMarket.events.PurchaseEvent
import com.bookmarket.bookMarket.exception.NotFoundException
import com.bookmarket.bookMarket.model.PurchaseModel
import com.bookmarket.bookMarket.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PurchaseService(
    private val purchaserRepository: PurchaseRepository,
    //Serve para disparar um evento
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    @Transactional
    fun create(purchaseModel: PurchaseModel) {
        purchaserRepository.save(purchaseModel)
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
        // this = quem está disparando o evento

    }

    //Para salvar a nfe
    fun update(purchaseModel: PurchaseModel) {
        purchaserRepository.save(purchaseModel)
    }

    fun readPurchase(pageable: Pageable): Page<PurchaseModel> {
        return purchaserRepository.findAll(pageable)
    }

    fun readPurchaseViaId(id: Int): PurchaseModel {
        return purchaserRepository.findById(id)
            .orElseThrow { NotFoundException(Erros.ML301.message.format(id), Erros.ML301.code) }
    }


}

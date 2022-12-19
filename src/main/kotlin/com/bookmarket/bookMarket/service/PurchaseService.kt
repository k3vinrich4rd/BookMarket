package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.model.PurchaseModel
import com.bookmarket.bookMarket.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaserRepository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaserRepository.save(purchaseModel)
    }
}

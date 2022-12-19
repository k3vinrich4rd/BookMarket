package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<PurchaseModel, Int> {

}

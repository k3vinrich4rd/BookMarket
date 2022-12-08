package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int> {
    fun findByNameContaining(name: String): List<CustomerModel>
}
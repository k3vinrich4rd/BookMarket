package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int> {
    //Query method:
    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>
}
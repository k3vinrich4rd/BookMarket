package com.bookmarket.bookMarket.repository

import com.bookmarket.bookMarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<CustomerModel, Int> {

    //Query method:
    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>
    fun existsByEmail(email: String): Boolean
}
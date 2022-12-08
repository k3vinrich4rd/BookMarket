package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.repository.CustomerRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    //Save


    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }


    //Query parameter
    fun readForName(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
        // Para efetuar as buscas: localhost:8080/customers?name=Let
    }

    //FindById
    fun readCustomerViaId(id: Int): CustomerModel {//optional
        return customerRepository.findById(id).orElseThrow() //Exception (Tratativa de erro)
    }

    //Save
    fun updateCustomer(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) { //Para dar certeza que o método vai estar preenchido
            throw Exception()
        }
        customerRepository.save(customer)

    }

    //Delete
    fun deleteCustomer(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception()
        }
        customerRepository.deleteById(id)
    }
}


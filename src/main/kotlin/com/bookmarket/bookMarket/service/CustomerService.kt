package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository, //Injeção de dependência
    val bookService: BookService
) {
    //Save
    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }


    //Query method e find all
    fun readForName(name: String?): List<CustomerModel> {
        name?.let {// Se o nome não for null,  retorne
            // Para efetuar as buscas: localhost:8080/customers?name=Let
            return customerRepository.findByNameContainingIgnoreCase(it)
        }
        return customerRepository.findAll().toList()

    }

    //FindById com exceção
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
        val readCustomerViaId = readCustomerViaId(id)
        bookService.deleteByCustomer(readCustomerViaId)
        customerRepository.deleteById(id)

    }
}


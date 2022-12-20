package com.bookmarket.bookMarket.service

import com.bookmarket.bookMarket.enums.CustomerStatus
import com.bookmarket.bookMarket.enums.Erros
import com.bookmarket.bookMarket.enums.Profile
import com.bookmarket.bookMarket.exception.NotFoundException
import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

//Camada de regra de negócio
@Service
class CustomerService(
    private val customerRepository: CustomerRepository, //Injeção de dependência
    private val bookService: BookService,
    private val bCrypt: BCryptPasswordEncoder
) {
    //Save
    fun createCustomer(customer: CustomerModel) {
        val customerCopy = customer.copy(
            //setOf = Conjunto de
            roles = setOf(Profile.CUSTOMER), //Customer comum
            password = bCrypt.encode(customer.password) //Para criptografar a senha
        ) //Para criar uma cópia (um objeto) e passar informações diferentes

        customerRepository.save(customerCopy)
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
    fun readCustomerViaId(id: Int): CustomerModel {//optional                     //ML-001 é um erro da aplicação em si
        return customerRepository.findById(id)
            .orElseThrow { NotFoundException(Erros.ML201.message.format(id), Erros.ML201.code) }
    }                                                                                //Argumentos da classe

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
        bookService.deleteByCustomer(readCustomerViaId)  //Pega o id de customer
        readCustomerViaId.status = CustomerStatus.INACTIVE
        customerRepository.save(readCustomerViaId) //Deleta as suas informações

    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }

    fun findByCustomersActives(pageable: Pageable): Page<CustomerModel> {
        return customerRepository.findByStatus(CustomerStatus.ACTIVE, pageable)


    }
}


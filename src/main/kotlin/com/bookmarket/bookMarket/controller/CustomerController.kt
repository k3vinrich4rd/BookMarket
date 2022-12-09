package com.bookmarket.bookMarket.controller

import com.bookmarket.bookMarket.extension.toCustomerModel
import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.model.dto.request.PostCustomerRequestDto
import com.bookmarket.bookMarket.model.dto.request.PutCustomerRequestDto
import com.bookmarket.bookMarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
    val customerService: CustomerService //Injeção de dependência
) {

    //Em kotlin não precisa colocar a palavra reservada 'path'
    //Para indicar o caminho da requisição http
    //Criando um crud por completo (Sem banco de dados)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequestDto) {
        customerService.createCustomer(customer.toCustomerModel())
    }

    //Query method
    @GetMapping
    //Para efetuar a busca: ?name=Kevin Richard
    fun readForName(@RequestParam name: String?): List<CustomerModel> {
        return customerService.readForName(name)
    }

    @GetMapping("/{id}")
    fun readCustomerViaId(@PathVariable id: Int): CustomerModel {
        return customerService.readCustomerViaId(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: PutCustomerRequestDto) { //Implementação do Dto
        return customerService.updateCustomer(customer.toCustomerModel(id))
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }

}
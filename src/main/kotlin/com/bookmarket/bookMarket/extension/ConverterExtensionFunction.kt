package com.bookmarket.bookMarket.extension

import com.bookmarket.bookMarket.model.CustomerModel
import com.bookmarket.bookMarket.model.dto.PostCustomerRequestDto
import com.bookmarket.bookMarket.model.dto.PutCustomerRequestDto


fun PostCustomerRequestDto.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequestDto.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}
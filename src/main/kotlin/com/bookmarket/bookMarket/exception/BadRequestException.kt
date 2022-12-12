package com.bookmarket.bookMarket.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception() {
}
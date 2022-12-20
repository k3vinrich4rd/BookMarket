package com.bookmarket.bookMarket.exception

class AuthenticationException(override val message: String, val errorCode: String) : Exception()

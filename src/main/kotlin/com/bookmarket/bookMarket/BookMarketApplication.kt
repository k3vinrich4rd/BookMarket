package com.bookmarket.bookMarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookMarketApplication

fun main(args: Array<String>) {
	runApplication<BookMarketApplication>(*args)
}

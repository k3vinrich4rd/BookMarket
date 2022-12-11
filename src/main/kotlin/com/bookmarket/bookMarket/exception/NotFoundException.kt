package com.bookmarket.bookMarket.exception
//':' significa ser uma extensão
//Só é preciso colocar override em métodos que necessário sobrescrever

class NotFoundException(
    override val message: //Parâmetro
    String, val errorCode: String) : Exception() { //Parâmetro
}
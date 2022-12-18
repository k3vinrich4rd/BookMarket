package com.bookmarket.bookMarket.exception
//':' significa ser uma extensão
//Só é preciso colocar override em métodos que necessário sobrescrever

class NotFoundException(
    //A exception (classe de extensão) já tem o atributo message, por isso é necessário sobrescrever
    override val message: String, //Parâmetro
    //Esse campo não precisa porque ele não existe na exception somente na notFound
    val errorCode: String //Parâmetro
) : Exception() { //Extensão
}
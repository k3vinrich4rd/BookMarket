package com.bookmarket.bookMarket.exception
//':' significa ser uma extens�o
//S� � preciso colocar override em m�todos que necess�rio sobrescrever

class NotFoundException(
    override val message: //Par�metro
    String, val errorCode: String) : Exception() { //Par�metro
}
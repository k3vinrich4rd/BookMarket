package com.bookmarket.bookMarket.exception

//':' significa ser uma extens�o
//S� � preciso colocar override em m�todos que necess�rio sobrescrever
class BadRequestException(
    //A exception (classe de extens�o) j� tem o atributo message, por isso � necess�rio sobrescrever o atributo
    override val message: String //Par�metro
    //Esse campo n�o precisa porque ele n�o existe na exception somente na notFound
    , val errorCode: String //Par�metro
) : Exception() { //Extens�o
}
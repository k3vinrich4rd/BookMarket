package com.bookmarket.bookMarket.events

import com.bookmarket.bookMarket.model.PurchaseModel
import org.springframework.context.ApplicationEvent;

//Evento de compra
class PurchaseEvent(

    // n�o precisa declarar uma var�vel porqu� o ApplicationEvent j� tem o atributo
    source: Any,     // -------//Quem est� disparando o evento (algu�m)
    val purchaseModel: PurchaseModel
): ApplicationEvent(source)
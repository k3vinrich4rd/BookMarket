package com.bookmarket.bookMarket.events

import com.bookmarket.bookMarket.model.PurchaseModel
import org.springframework.context.ApplicationEvent;

//Evento de compra
class PurchaseEvent(

    // não precisa declarar uma varável porquê o ApplicationEvent já tem o atributo
    source: Any,     // -------//Quem está disparando o evento (alguém)
    val purchaseModel: PurchaseModel
): ApplicationEvent(source)
package com.bookmarket.bookMarket.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Entity(name = "purchase")
data class PurchaseModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne //Muitas compras para um customer
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,


    @ManyToMany //Muitas compras para muitos livros
    @JoinTable(name = "purchase_book",   //Tabela intermediaria que junta livros com as compras
        joinColumns = [JoinColumn(name = "purchase_id")],//Aqui é onde declaramos a coluna que referência a tabela de compras
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    ) //Para linkar para fazer a compra
    val books: List<BookModel>,

    @Column(name = "purchase_electronic_invoice", length = 100, nullable = true)
    val nfe: String? = null, //Nota fiscal eletrônica

    @Column(name = "purchase_price", nullable = true)
    val price: BigDecimal,

    @Column(name = "purchase_created_at", nullable = true)
    val createdAt: LocalDateTime = LocalDateTime.now()


)
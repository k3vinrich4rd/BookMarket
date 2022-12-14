package com.bookmarket.bookMarket.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "purchase")
data class PurchaseModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne //Muitas compras para um customer
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,


    @ManyToMany //Muitas compras para muitos livros
    @JoinTable(
        name = "purchase_book",   //Tabela intermediaria que junta livros com as compras
        joinColumns = [JoinColumn(name = "purchase_id")],//Aqui ? onde declaramos a coluna que refer?ncia a tabela de compras
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    ) //Para linkar para fazer a compra
    val books: MutableList<BookModel>,

    @Column(name = "purchase_electronic_invoice", length = 100, nullable = true)
    val nfe: String? = null, //Nota fiscal eletr?nica

    @Column(name = "purchase_price", nullable = true)
    val price: BigDecimal,

    @Column(name = "purchase_created_at", nullable = true)
    val createdAt: LocalDateTime = LocalDateTime.now()


)
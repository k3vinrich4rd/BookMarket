package com.bookmarket.bookMarket.model

import com.bookmarket.bookMarket.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "name_book", length = 70, nullable = true)
    var name: String,

    @Column(name = "price_book", nullable = true, precision = 10, scale = 2)
    var price: BigDecimal,

    @Column(name = "status_book", length = 70, nullable = true)
    @Enumerated(EnumType.STRING) //Texto
    var status: BookStatus? = null,

    @ManyToOne //Muitos para um
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

)

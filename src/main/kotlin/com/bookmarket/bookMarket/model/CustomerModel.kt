package com.bookmarket.bookMarket.model

import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "customer_name", length = 70, nullable = true)
    var name: String,

    @Column(name = "customer_email", length = 70, nullable = true, unique = true)
    var email: String

)
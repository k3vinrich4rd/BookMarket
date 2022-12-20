package com.bookmarket.bookMarket.model

import com.bookmarket.bookMarket.enums.CustomerStatus
import javax.persistence.*

//Modelagem do cliente
@Entity(name = "customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "customer_name", length = 70, nullable = true)
    var name: String,

    @Column(name = "customer_email", length = 70, nullable = true, unique = true)
    var email: String,

    @Column(name = "customer_status", length = 70, nullable = true)
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus
)


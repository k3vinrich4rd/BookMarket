package com.bookmarket.bookMarket.model

import com.bookmarket.bookMarket.enums.CustomerStatus
import com.bookmarket.bookMarket.enums.Profile
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
    var status: CustomerStatus,

    @Column(name = "password_customer", length = 255, nullable = true)
    val password: String,


    /*Spring security:
    //Guiando o spring para qual tabela ele deve olhar para saber as informações referentes a roles
    No caso ele vai ter que ver a coluna de customer_id para saber qual role é referente a cada customer
     */
    @CollectionTable(name = "customer_roles", joinColumns = [JoinColumn(name = "customer_id")])
    // Toda vez que a aplicação fazer um tipo de busca, também buscar as roles
    @ElementCollection(targetClass = Profile::class, fetch = FetchType.EAGER)
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    var roles: Set<Profile> = setOf()//Porque um set é uma lista que não recebe valores iguais
)


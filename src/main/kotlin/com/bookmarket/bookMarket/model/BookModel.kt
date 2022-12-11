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


    @ManyToOne //Muitos para um
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null

) {
    @Column(name = "status_book", length = 70, nullable = true)
    @Enumerated(EnumType.STRING) //Texto
    var status: BookStatus? = null
        set(value) { // value = novo valor do atributo
            //Verificando se valor da variável é igual a cancelado ou deletado
            //Se for, vai estourar uma exception
            if (field == BookStatus.CANCELED || field == BookStatus.DELETED) {//field =  valor atual do atributo
                throw Exception("Unable to change a book with status $field ")
            }
            //Se não, vai sobrescrever o valor de field
            field = value
        }


    //Como criar um construtor na mão:
    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?) : this(id, name, price, customer) {
        //this invoca o construtor logo acima (da classe padrão)
        this.status = status

     }


}



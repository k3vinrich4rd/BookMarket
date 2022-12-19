package com.bookmarket.bookMarket.enums

//Atributos presentes nas exceptions (Bad request e NotFound)
// passados como parâmetro nesta classe enum
enum class Erros(val code: String, val message: String) {
    ML001("ML-001", "Invalid Request"), // Erros genéricos
    ML101("ML-101", "Book [$%s] not exists"), //Erros de 100 199 referentes a livros
    ML102("ML-102", "cannot update book with status [%s]"), //Erros de 100 199 referentes a livros
    ML201("ML-201", "Customer [$%s] not exists"), // Erros de 200 a 299 referentes a customer
    ML301("ML-301", "Purchase [$%s] not exists") //Erros de 300 a 399 referentes a purchase
}

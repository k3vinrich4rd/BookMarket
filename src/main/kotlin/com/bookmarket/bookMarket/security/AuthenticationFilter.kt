package com.bookmarket.bookMarket.security

import com.bookmarket.bookMarket.exception.AuthenticationException
import com.bookmarket.bookMarket.model.dto.request.LoginRequest
import com.bookmarket.bookMarket.repository.CustomerRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter( //Filtro de autenticações
    authenticationManager: AuthenticationManager,
    private val customerRepository: CustomerRepository
) : UsernamePasswordAuthenticationFilter(authenticationManager) { //Próprio do spring Security

    //Isso que foi feito logo abaixo vai ser utilizado quando a url do barra /login for requisitado
    //Na linha abaixo recebemos a request e response
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {


        //JacksonObjectMapper = Transforma um objeto para outro (se tiverem os mesmos atributos)
        try {
            //Aqui pegamos a request e transformamos o que vem no body dela, no objeto de login e request
            //recebimento de email e senha
            val loginRequest = jacksonObjectMapper().readValue(request.inputStream, LoginRequest::class.java)

            /*Encontrando o email, vamos apenas querer o id, pois é por ele que vamos fazer a autenticação
            //Mantendo no token o id ao invés do email, porque nós não queremos deixar nenhuma informação sensível
            Mas sim sistêmica */
            val id = customerRepository.findByEmail(loginRequest.email)?.id

            //Depois criamos um auth token "UsernamePasswordAuthenticationToken" (próprio do spring security)
            //O id continua no token, para não causar nenhum problema de vazamento de dados sensível
            //E a credential, é a senha no caso
            val authToken =
                UsernamePasswordAuthenticationToken(id, loginRequest.password)// depois informo o id e senha
            return authenticationManager.authenticate(authToken) //Indicando pro spring qual token ele tem que validar e verificar se está tudo certo
        } catch (ex: Exception) {//Caso de tudo errado ele cai no catch
            throw AuthenticationException("Falha ao autenticar", "999")
        }


    }
}
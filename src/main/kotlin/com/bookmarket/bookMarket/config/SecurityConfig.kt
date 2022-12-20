@file:Suppress("DEPRECATION")

package com.bookmarket.bookMarket.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity // == Habilitar segurança da web
class SecurityConfig() {


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors().and().csrf().disable() //Cors = núcleos
        //Estamos falando aqui que as requisições vão ser independentes
        http.authorizeRequests().anyRequest().authenticated() //Todas as requisições têm que estar autenticadas
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return http.build()
    }

    @Bean //Para criptografar a senha
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}


/*  outra forma de implementação

  override fun configure(http: HttpSecurity) { //Cors = núcleos
//        http.cors().and().csrf().disable() //Para desabilitar o csrf
//        //Estamos falando aqui que as requisições vão ser independentes
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
   }

    @Bean //Para criptografar a senha
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

*/

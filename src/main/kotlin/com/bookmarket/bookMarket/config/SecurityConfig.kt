@file:Suppress("DEPRECATION")

package com.bookmarket.bookMarket.config

import com.bookmarket.bookMarket.repository.CustomerRepository
import com.bookmarket.bookMarket.security.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity // == Habilitar seguran�a da web
class SecurityConfig(
    private val customerRepository: CustomerRepository
) : WebSecurityConfigurerAdapter() {


    //Assim fica mais f�cil e mold�vel, pois caso queira colocar mais uma libera��o,
    //basta adicionar na lista (Tirando a necessidade de ficar escrevendo na m�o)
    public val publicMatchers = arrayOf<String>()
    private val publicPostMatchers = arrayOf(
        "/customers"
    )

    /*
    Curiosidade: O Spring cria uma rota /login, tirando a necessidade de criar um controller
    para o seu gerenciamento especifico, n�s s� precisamos ensinar o spring como vai ser feito essa
    autentica��o (criando um filtro)
     */


    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
        http.authorizeRequests()
            .antMatchers(*publicMatchers).permitAll()
            .antMatchers(HttpMethod.POST, *publicPostMatchers).permitAll()
            .anyRequest().authenticated()
        http.addFilter(AuthenticationFilter(authenticationManager(), customerRepository))
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }


    @Bean //Para criptografar a senha
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}


//Tive que voltar para vers�o anterior (Descontinuada), pois
//n�o sei como aplicar uma funcionalidade que o projeto necessita na nova vers�o

//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http.cors().and().csrf().disable() //Cors = n�cleos
//        //Estamos falando aqui que as requisi��es v�o ser independentes
//        http.authorizeRequests()
//            //Para liberar o customer se cadastrar
//            //O '*' modulariza e passa todos os registros da lista como se fossem varias Strings
//            .antMatchers(HttpMethod.POST, *publicPostMatchers).permitAll() //Aceita infinitos par�metros
//            .anyRequest().authenticated() //Todas as requisi��es t�m que estar autenticadas
//      http.addFilter(AuthenticationFilter(authenticationManager(), customerRepository ))
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//        return http.build()
//    }


/*  outra forma de implementa��o (Antiga e descontinuada)

  override fun configure(http: HttpSecurity) { //Cors = n�cleos
//        http.cors().and().csrf().disable() //Para desabilitar o csrf
//        //Estamos falando aqui que as requisi��es v�o ser independentes
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
   }

    @Bean //Para criptografar a senha
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

*/

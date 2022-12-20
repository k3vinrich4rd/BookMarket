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
@EnableWebSecurity // == Habilitar segurança da web
class SecurityConfig(
    private val customerRepository: CustomerRepository
) : WebSecurityConfigurerAdapter() {


    //Assim fica mais fácil e moldável, pois caso queira colocar mais uma liberação,
    //basta adicionar na lista (Tirando a necessidade de ficar escrevendo na mão)
    public val publicMatchers = arrayOf<String>()
    private val publicPostMatchers = arrayOf(
        "/customers"
    )

    /*
    Curiosidade: O Spring cria uma rota /login, tirando a necessidade de criar um controller
    para o seu gerenciamento especifico, nós só precisamos ensinar o spring como vai ser feito essa
    autenticação (criando um filtro)
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


//Tive que voltar para versão anterior (Descontinuada), pois
//não sei como aplicar uma funcionalidade que o projeto necessita na nova versão

//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http.cors().and().csrf().disable() //Cors = núcleos
//        //Estamos falando aqui que as requisições vão ser independentes
//        http.authorizeRequests()
//            //Para liberar o customer se cadastrar
//            //O '*' modulariza e passa todos os registros da lista como se fossem varias Strings
//            .antMatchers(HttpMethod.POST, *publicPostMatchers).permitAll() //Aceita infinitos parâmetros
//            .anyRequest().authenticated() //Todas as requisições têm que estar autenticadas
//      http.addFilter(AuthenticationFilter(authenticationManager(), customerRepository ))
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//        return http.build()
//    }


/*  outra forma de implementação (Antiga e descontinuada)

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

package br.gov.sp.fatec.lab5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // a notação significa que o que estivar anotado está seguro e o restante está aberto
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and() // csrf - Metodo de segurança por token, usando quando o back e o front
                                                // são misturados
                // depois de utilizar a sessão a memória dela será descartada
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // rest será stateless
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean () throws Exception{
        return super.authenticationManager();
    }

}
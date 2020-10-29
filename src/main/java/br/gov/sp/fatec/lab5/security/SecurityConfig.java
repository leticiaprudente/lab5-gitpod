package br.gov.sp.fatec.lab5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // a notação significa que o que estivar anotado está seguro e o
                                                   // restante está aberto
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(). // csrf - Metodo de segurança por token, usando quando o back e o front são
                               // misturados
                httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // rest
                                                                                                              // será
                                                                                                              // stateless
        // depois de utilizar a sessão a memória dela será descartada
    }

    @Bean // faz autowired para classes que não são autorais e disponibiliza para demais classes
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

}
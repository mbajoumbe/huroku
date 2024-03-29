package co.simplon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService UserDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       /* auth.inMemoryAuthentication()
                .withUser("admin").password("1234").roles("ADMIN","USER").
        and()
                .withUser("user").password("1234").roles("USER");

        auth.userDetailsService(UserDetailsService)
        .passwordEncoder(bCryptPasswordEncoder);

  */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.formLogin();
         http.authorizeRequests().anyRequest().authenticated();

    }
}


package com.example.securityapplication.config;

import com.example.securityapplication.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                //.csrf().disable()
                .authorizeRequests()
                .antMatchers("/reqres.in/api/**").permitAll()
                .antMatchers("/authentication/login", "/error", "/main", "/authentication/registration").permitAll()
                .antMatchers("/admin", "/restapi", "/api/info").hasRole("ADMIN")
                .anyRequest().hasAnyRole("USER", "ADMIN")
                //.authenticated()
                .and()
                .formLogin().loginPage("/authentication/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/authentication/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/main");
    }

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder());
    }


    //WebSecurityConfiguration {
    //   private final AuthenticationProvider authenticationProvider;

    //
            //   public SecurityConfig(AuthenticationProvider authenticationProvider) {
        //       this.authenticationProvider = authenticationProvider;
        //   }

    //   protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        //       authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        //   }

}

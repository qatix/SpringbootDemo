package com.qatix.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/","/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//             .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//             .logout()
//                .permitAll();

        //对api请求忽略csrf检查
        http.csrf().ignoringAntMatchers("/department/*","/product/*",
                "/category/*","/worker/*","/city/*");
        //ref-link: https://github.com/spring-projects/spring-boot/issues/179
//        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();


    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("tang")
                .password("123456")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}

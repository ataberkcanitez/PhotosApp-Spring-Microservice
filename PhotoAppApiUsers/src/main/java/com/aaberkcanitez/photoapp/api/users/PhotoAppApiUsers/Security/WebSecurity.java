package com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Security;

import com.aaberkcanitez.photoapp.api.users.PhotoAppApiUsers.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment environment;
    private UsersService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public WebSecurity(Environment environment,UsersService userService,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.environment = environment;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users/**").permitAll()
                .and()
                .addFilter(getAuthenticationFilter());
        //normalde permitall değil, ip'ye göre çekiyoruz, sonra da
        // .and()
        // .addFilter(geetAuthenticationFilter()); diyoruz.
        http.headers().frameOptions().disable();
    }
    private AuthenticationFilter getAuthenticationFilter() throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(this.userService, this.environment, authenticationManager());
        //authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
        
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}

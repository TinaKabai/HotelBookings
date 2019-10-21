package za.ac.cput.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class HotelBookingSecurity extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    //@Override
    public void configure(AuthenticationManagerBuilder aut) throws Exception{
        aut
                .inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("2019Admin"))
                .roles(USER_ROLE,ADMIN_ROLE)
                .and()
                .withUser("user")
                .password(encoder().encode("2019User"))
                .roles(USER_ROLE);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                //.anyRequest().authenticated()
                .antMatchers(HttpMethod.POST, "/HotelBookings/lookup/**/create/**").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable();
                //.formLogin().disable();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}

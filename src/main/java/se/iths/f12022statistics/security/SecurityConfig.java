package se.iths.f12022statistics.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.iths.f12022statistics.service.UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userDetailService;

    public SecurityConfig(UserService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/races/**", "/api/drivers/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/races/**", "/api/drivers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/drivers/**", "/api/teams/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

package trainings.transaction.tracking.service.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/home").permitAll() // allow public access to these URLs
                                .anyRequest().authenticated()  // other requests require authentication
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")  // specify custom login page
                                .permitAll()  // allow everyone to access the login page
                )
                .logout(logout ->
                        logout.permitAll()  // allow everyone to access the logout page
                );
    }
}

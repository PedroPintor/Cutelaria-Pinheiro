package br.com.cutelaria_pinheiro.cutelaria_pinheiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;   
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.security.CustomAuthentication;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

   
    private final CustomAuthentication successHandler;


    public SecurityConfig(CustomAuthentication successHandler) {
        this.successHandler = successHandler;
        
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("teste")
        .password(passwordEncoder().encode("123"))
        .roles("ADMIN")
        .build();
        return new InMemoryUserDetailsManager(admin);
    }
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
            .authorizeHttpRequests((authz) -> authz
            .requestMatchers("/adm/**").hasRole("ADMIN")
            .requestMatchers("/index/**").permitAll()
            .requestMatchers("/public/**").permitAll() // Acesso público
            .anyRequest().authenticated() // Qualquer outra requisição requer autenticação
            )
            .formLogin((form) -> form
            // Definir página de login personalizada
            //.loginPage("/login")
            // Usar o handler customizado para redirecionamento após login
            .successHandler(successHandler)
            .permitAll()
            )
            .logout((logout) -> logout
            //.logoutUrl("/home/logout") // URL de logout
            .logoutSuccessUrl("/cutelaria-pinheiro/") // Redirecionar para /index após logout
            .permitAll()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")) // Logout via POST
            );

        return http.build();
    }

}
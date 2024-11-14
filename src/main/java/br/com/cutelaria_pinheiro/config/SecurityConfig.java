package br.com.cutelaria_pinheiro.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.UserService;


@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    private final CustomAuthentication successHandler;

    public SecurityConfig(CustomAuthentication successHandler) {
        this.successHandler = successHandler;
    }

 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
            .authorizeHttpRequests((authz) -> authz
            // Permitir acesso a todas as rotas em /public/** sem autenticação
            .requestMatchers("/cutelaria-pinheiro/**").permitAll()

            // Requer login e papel de ADMIN para /admin/**
            .requestMatchers("/administrador/**").hasRole("ADMIN")

            // Liberar tudo o que estiver fora dos diretórios /user/e /admin/
            .anyRequest().permitAll()
            )

            .formLogin((form) -> form
                // Definir página de login personalizada
                .loginPage("/login")
                // Usar o handler customizado para redirecionamento apóslogin
                .successHandler(successHandler)
                .permitAll()
            )
            
            .logout((logout) -> logout
                // URL de logout
                .logoutUrl("/logout")
                // Redirecionar para /index após logout
                .logoutSuccessUrl("/cutelaria-pinheiro")
                .permitAll()
                // Logout via POST
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST")));

            return http.build();
 }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("U")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
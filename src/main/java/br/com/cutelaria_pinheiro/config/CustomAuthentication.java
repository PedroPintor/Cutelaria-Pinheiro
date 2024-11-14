package br.com.cutelaria_pinheiro.config;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthentication implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {

        try {
            Set<String> roles = authentication.getAuthorities().stream()
            .map( grantedAuthority -> grantedAuthority.getAuthority())
            .collect(Collectors.toSet());
    
            if ( roles.contains("ADMIN")){
                response.sendRedirect("/administrador/home");
            } else {
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
        }

    }
    
}

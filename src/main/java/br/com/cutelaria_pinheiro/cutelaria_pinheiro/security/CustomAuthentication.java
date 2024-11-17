package br.com.cutelaria_pinheiro.cutelaria_pinheiro.security;

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
        
            Set<String> roles = authentication.getAuthorities().stream()
            .map( grantedAuthority -> grantedAuthority.getAuthority())
            .collect(Collectors.toSet());
    
            if ( roles.contains("ROLE_ADMIN")){
                response.sendRedirect("/administrador/produtos/home");
            } else {
                response.sendRedirect("/cutelaria-pinheiro");
            }

    }
    
}

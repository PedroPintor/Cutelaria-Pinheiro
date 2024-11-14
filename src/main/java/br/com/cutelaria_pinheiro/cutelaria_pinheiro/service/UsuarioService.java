package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Usuario;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.UsuarioRepository;



@Service
public class UsuarioService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findById(UUID id){
        return usuarioRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario admin = usuarioRepository.findByNome(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Converte a entidade Administrador em um UserDetails do Spring Security
        return User.withUsername(admin.getNome())
            .password(admin.getSenha())
            .roles(admin.getPapel()) // define o papel do usuário
            .build();
    }

}

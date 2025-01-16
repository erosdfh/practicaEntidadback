package com.mantenimiento.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.mantenimiento.entities.Usuario;
import com.mantenimiento.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Usuario usuario = userRepository.getUser(username);

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPsw()) // Contraseña codificada
                .roles()
                .build();
    }
}


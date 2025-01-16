package com.mantenimiento.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mantenimiento.entities.Usuario;
import com.mantenimiento.exceptions.ErrorException;

public interface UserService {

	public Usuario getUser(Usuario user) throws ErrorException;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

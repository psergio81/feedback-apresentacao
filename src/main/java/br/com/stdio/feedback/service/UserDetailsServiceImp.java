package br.com.stdio.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.stdio.feedback.model.Usuario;
import br.com.stdio.feedback.repository.UsuarioRepository;
import br.com.stdio.feedback.security.UserSpringSecurity;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario u = usuarioRepository.findByEmail(email);
		
		if (u == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSpringSecurity(u.getId(), u.getEmail(), u.getSenha(), u.getPerfis());
	}

}

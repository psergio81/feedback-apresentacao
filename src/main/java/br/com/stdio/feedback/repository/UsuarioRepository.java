package br.com.stdio.feedback.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.stdio.feedback.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Transactional(readOnly = true)
	Usuario findByEmail(String email);

}

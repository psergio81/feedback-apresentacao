package br.com.stdio.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.stdio.feedback.model.Voto;
import java.lang.Long;
import java.util.List;

public interface VotoRepository extends CrudRepository<Voto, Long> {

	List<Voto> findByCodigoApresentacao(Long codigoapresentacao);

	
}

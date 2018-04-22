package br.com.stdio.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stdio.feedback.model.Voto;
import br.com.stdio.feedback.repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;

	public Iterable<Voto> findByCodigoApresentacao(Long codigoapresentacao) {
		return votoRepository.findByCodigoApresentacao(codigoapresentacao);
	}
	
	
	
}

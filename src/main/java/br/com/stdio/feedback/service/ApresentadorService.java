package br.com.stdio.feedback.service;

import org.springframework.stereotype.Service;

import br.com.stdio.feedback.model.Apresentador;
import br.com.stdio.feedback.repository.ApresentadorRepository;

@Service
public class ApresentadorService {

	private ApresentadorRepository apresentadorRepository;

	public ApresentadorService(ApresentadorRepository apresentadorRepository) {
		super();
		this.apresentadorRepository = apresentadorRepository;
	};

	public Apresentador insert(Apresentador apresentador) {
		return apresentadorRepository.save(apresentador);
	}

}

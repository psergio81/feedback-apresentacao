package br.com.stdio.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.repository.ApresentacaoRepository;

@Service
public class ApresentacaoService {

	@Autowired
	private ApresentacaoRepository apresentacaoRepository;
	
	public Apresentacao inserir(Apresentacao apresentacao) {

		return apresentacaoRepository.save(apresentacao);
	}

}

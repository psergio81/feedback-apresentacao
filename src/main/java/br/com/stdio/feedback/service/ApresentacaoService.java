package br.com.stdio.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.model.Voto;
import br.com.stdio.feedback.repository.ApresentacaoRepository;

@Service
public class ApresentacaoService {

	@Autowired
	private ApresentacaoRepository apresentacaoRepository;

	@Autowired
	private VotoService votoService;

	public Apresentacao inserir(Apresentacao apresentacao) {

		return apresentacaoRepository.save(apresentacao);
	}

	public Iterable<Apresentacao> findAll() {
		Iterable<Apresentacao> todasApresentacoes = apresentacaoRepository.findAll();


		for (Apresentacao apresentacao : todasApresentacoes) {

			Iterable<Voto> votos = votoService.findByCodigoApresentacao(apresentacao.getId());
			
			apresentacao.setTotalVotos(votos.spliterator().estimateSize());
		}

		return todasApresentacoes;
	}

}

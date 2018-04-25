package br.com.stdio.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.model.StatusApresentacao;
import br.com.stdio.feedback.model.Voto;
import br.com.stdio.feedback.repository.ApresentacaoRepository;

@Service
public class ApresentacaoService {

	@Autowired
	private ApresentacaoRepository apresentacaoRepository;

	@Autowired
	private VotoService votoService;

	public Apresentacao inserir(Apresentacao apresentacao) {

		apresentacao.setStatus(StatusApresentacao.ATIVA);
		
		return apresentacaoRepository.save(apresentacao);
	}

	public Iterable<Apresentacao> findAll() {
		Iterable<Apresentacao> todasApresentacoes = apresentacaoRepository.findAll();


		for (Apresentacao apresentacao : todasApresentacoes) {
			setVotosDaApresentacao(apresentacao);
		}

		return todasApresentacoes;
	}

	private void setVotosDaApresentacao(Apresentacao apresentacao) {
		Iterable<Voto> votos = votoService.findByCodigoApresentacao(apresentacao.getId());
		
		apresentacao.setTotalVotos(votos.spliterator().estimateSize());
	}

	public Apresentacao ativar(Long id) {

		Apresentacao apresentacao = findOne(id);
		apresentacao.setStatus(StatusApresentacao.ATIVA);
		
		apresentacao = apresentacaoRepository.save(apresentacao);
		setVotosDaApresentacao(apresentacao);
		
		return apresentacao;
	}

	public Apresentacao findOne(Long id) {
		return apresentacaoRepository.findOne(id);
	}

	public Apresentacao inativar(Long id) {
		
		Apresentacao apresentacao = findOne(id);
		
		apresentacao.setStatus(StatusApresentacao.INATIVA);
		
		apresentacao = apresentacaoRepository.save(apresentacao);
		setVotosDaApresentacao(apresentacao);
				
		return apresentacao;
	}

	public void excluir(Long codigo) {

		apresentacaoRepository.delete(codigo);
		
	}

}

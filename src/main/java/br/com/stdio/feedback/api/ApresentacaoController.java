package br.com.stdio.feedback.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.repository.ApresentacaoRepository;
import br.com.stdio.feedback.service.ApresentacaoService;

@RestController
@RequestMapping("api/apresentacoes")
public class ApresentacaoController {

	private ApresentacaoService apresentacaoService;
	private ApresentacaoRepository apresentacaoRepository;

	@Autowired
	public ApresentacaoController(ApresentacaoService apresentacaoService, ApresentacaoRepository apresentacaoRepository) {
		super();
		this.apresentacaoService = apresentacaoService;
		this.apresentacaoRepository = apresentacaoRepository;
	}

	@RequestMapping("/nova-apresentacao")
	public ResponseEntity<Apresentacao> salvar(@RequestBody Apresentacao apresentacao) {

		Apresentacao apresentacaoInserida = apresentacaoService.inserir(apresentacao);

		return new ResponseEntity<Apresentacao>(apresentacaoInserida, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public Iterable<Apresentacao> findAll() {
		return apresentacaoRepository.findAll();
	}

}

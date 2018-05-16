package br.com.stdio.feedback.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.model.StatusApresentacao;
import br.com.stdio.feedback.service.ApresentacaoService;

@CrossOrigin
@RestController
@RequestMapping("api/apresentacoes")
public class ApresentacaoApiController {

	private ApresentacaoService apresentacaoService;

	@Autowired
	public ApresentacaoApiController(ApresentacaoService apresentacaoService) {
		super();
		this.apresentacaoService = apresentacaoService;
	}

	@RequestMapping("/nova-apresentacao")
	public ResponseEntity<Apresentacao> salvar(@RequestBody Apresentacao apresentacao) {

		apresentacao.setStatus(StatusApresentacao.ATIVA);
		Apresentacao apresentacaoInserida = apresentacaoService.inserir(apresentacao);

		return new ResponseEntity<Apresentacao>(apresentacaoInserida, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public Iterable<Apresentacao> findAll() {
		return  apresentacaoService.findAll();
	}
	
	@RequestMapping("{id}/ativar")
	public ResponseEntity<Apresentacao> ativar(@PathVariable Long id){
		
		Apresentacao apresentacaoAlterada = apresentacaoService.ativar(id);
		
		return new ResponseEntity<Apresentacao>(apresentacaoAlterada, HttpStatus.OK);
	}

	@RequestMapping("{id}/inativar")
	public ResponseEntity<Apresentacao> inativar(@PathVariable Long id){
		
		Apresentacao apresentacaoAlterada = apresentacaoService.inativar(id);
		
		return new ResponseEntity<Apresentacao>(apresentacaoAlterada, HttpStatus.OK);
	}

}

package br.com.stdio.feedback.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.stdio.feedback.model.Apresentador;
import br.com.stdio.feedback.repository.ApresentadorRepository;
import br.com.stdio.feedback.service.ApresentadorService;

@RestController
@RequestMapping("api/apresentadores")
public class ApresentadorController {
	
	private ApresentadorRepository apresentadorRepository;
	private ApresentadorService apresentadorService;
	
	@Autowired
	public ApresentadorController(ApresentadorRepository apresentadorRepository, ApresentadorService apresentadorService) {
		super();
		this.apresentadorRepository = apresentadorRepository;
		this.apresentadorService = apresentadorService;
	}

	@RequestMapping(value="/novo-apresentador", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Apresentador> salvar(@RequestBody Apresentador apresentador) {
		
		Apresentador apresentadorInserido = apresentadorService.insert(apresentador);
		
		return new ResponseEntity<>(apresentadorInserido, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Apresentador> findAll(){
		return apresentadorRepository.findAll();
	}

}

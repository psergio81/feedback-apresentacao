
package br.com.stdio.feedback.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.stdio.feedback.model.Voto;
import br.com.stdio.feedback.repository.VotoRepository;

@RestController
@RequestMapping("api/votos")
public class VotoController {

	private VotoRepository votoRepository;

	@Autowired
	public VotoController(VotoRepository votoRepository) {
		super();
		this.votoRepository = votoRepository;
	}

	@RequestMapping(path = "novo-voto")
	public ResponseEntity<Voto> salvar(@RequestBody Voto voto) {
		Voto votoInserido = votoRepository.save(voto);

		return new ResponseEntity<Voto>(votoInserido, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public Iterable<Voto> findAll() {
		return votoRepository.findAll();
	}

}

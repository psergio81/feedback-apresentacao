package br.com.stdio.feedback.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votacoes")
public class FeedbackController {

	@GetMapping
	public String pesquisar() {
		
		return "{votos : 1}";
	}
	
}

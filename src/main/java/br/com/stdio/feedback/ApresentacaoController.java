package br.com.stdio.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.service.ApresentacaoService;

@Controller
@RequestMapping("/apresentacoes")
public class ApresentacaoController {

	@Autowired
	private ApresentacaoService apresentacaoService;

	@RequestMapping("/nova")
	public ModelAndView nova() {

		ModelAndView mv = new ModelAndView("CadastroApresentacao");
		mv.addObject("apresentacao", new Apresentacao());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Apresentacao apresentacao, Errors errors) {

		ModelAndView mv = new ModelAndView("CadastroApresentacao");

		if (errors.hasErrors()) {
			mv.addObject("apresentacao", apresentacao);
			return mv;
		}
		
		Apresentacao apresentacaoInserida = apresentacaoService.inserir(apresentacao);
		mv.addObject("apresentacao", apresentacaoInserida);

		mv.addObject("mensagem", "Apresentação salva com sucesso!");
		
		return mv;
	}

	@RequestMapping
	public ModelAndView pesquisar() {

		ModelAndView mv = new ModelAndView("PesquisaApresentacao");
		mv.addObject("todasApresentacoes", apresentacaoService.findAll());

		return mv;
	}

}

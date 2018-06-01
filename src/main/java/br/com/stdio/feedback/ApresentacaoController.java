package br.com.stdio.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.stdio.feedback.model.Apresentacao;
import br.com.stdio.feedback.service.ApresentacaoService;

@RestController
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
	public String salvar(@Validated Apresentacao apresentacao, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return "CadastroApresentacao";
		}
		
		apresentacaoService.inserir(apresentacao);

		attributes.addFlashAttribute("mensagem", "Apresentação salva com sucesso!");
		
		return "redirect:/apresentacoes/nova";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping
	public ModelAndView pesquisar() {

		ModelAndView mv = new ModelAndView("PesquisaApresentacao");
		mv.addObject("todasApresentacoes", apresentacaoService.findAll());

		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView alterar(@PathVariable Long codigo) {
		
		ModelAndView mv = new ModelAndView("CadastroApresentacao");
		Apresentacao apresentacao = apresentacaoService.findOne(codigo);
		
		mv.addObject("apresentacao", apresentacao);
		
		return mv;
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		
		apresentacaoService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Apresentação excluída com sucesso!");
		
		return "redirect:/apresentacoes";
	}
	
	@RequestMapping("/grafico")
	public ModelAndView grafico() {

		ModelAndView mv = new ModelAndView("grafico");
		
		
		return mv;
	}

}

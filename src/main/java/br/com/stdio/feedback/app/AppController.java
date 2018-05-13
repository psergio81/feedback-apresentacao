package br.com.stdio.feedback.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class AppController {

	@RequestMapping()
	public ModelAndView voto() {

		ModelAndView mv = new ModelAndView("index");

		return mv;
	}

}

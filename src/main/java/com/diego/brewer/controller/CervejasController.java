package com.diego.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diego.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")//Quando digito isso no browser
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";//Vai me retornar essa página que está na pasta cerveja. HTML nna pasta de templates
	}
	
	//Esse request POST aqui pode ser encontrado no método POST lá no HTML
	//O Biding vai capturar o erro de validação
	//O model oferece a mensagem lá no span. Por isso tem o mesmo nome de mensagem
	//O RedirectAttributes redireciona a página.
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) { 
		
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}

}
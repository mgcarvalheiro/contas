package br.com.marcelocarvalheiro.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.marcelocarvalheiro.contas.dao.ContaDAO;
import br.com.marcelocarvalheiro.contas.model.Conta;

@Controller
public class ContaController {

	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.adiciona(conta);
		return "conta/conta-adicionada";
	}
	
	@RequestMapping(value="/form")
	public String form() {
		return "conta/formulario";
	}
	
	@RequestMapping(value="/listaContas")
	public ModelAndView lista() {
		ContaDAO contaDAO = new ContaDAO();
		List<Conta> contas = contaDAO.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);		
		return mv;
	}
}

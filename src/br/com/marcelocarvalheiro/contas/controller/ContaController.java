package br.com.marcelocarvalheiro.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.marcelocarvalheiro.contas.dao.ContaDAO;
import br.com.marcelocarvalheiro.contas.model.Conta;

@Controller
public class ContaController {

	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		
		if (result.hasErrors()) {
			return "conta/formulario";
		}
		
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
	
	@RequestMapping(value="/removeConta")
	public String remove(Conta conta) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.remove(conta);
		return "redirect:listaContas";
	}
	
	@RequestMapping(value="/pagarConta")
	public void pagar(Long id, HttpServletResponse response) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.paga(id);
		response.setStatus(200);
	}
}

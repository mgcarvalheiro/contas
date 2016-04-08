package br.com.marcelocarvalheiro.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.marcelocarvalheiro.contas.dao.UsuarioDAO;
import br.com.marcelocarvalheiro.contas.model.Usuario;

@Controller
public class LoginController {

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login/formulario-login";
	}
	
	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session) {
		if (new UsuarioDAO().existeUsuario(usuario)) {
			// usuario existe, guardaremos ele na session
			session.setAttribute("usuarioLogado", usuario);
			return "menu/menu";
		}
		// ele errou a senha, voltou para o formulario
		return "login/formulario-login";
	}
	
	@RequestMapping("/efetuarLogout")
	public String efetuarLogout(HttpSession session) {
		session.invalidate();
		return "login/formulario-login";
	}
}

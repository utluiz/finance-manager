package br.com.starcode.finance.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.starcode.finance.dao.UserDao;
import br.com.starcode.finance.model.User;

@Controller
public class LoginController {
	
	@Autowired UserDao userDao;
	
	@RequestMapping(value = "/login")
	ModelAndView loginError(
			@RequestParam String nomeUsuario, 
			@RequestParam String senha,
			HttpSession sessao) {
		
		//busca usuário
		User usuarioDoBanco = userDao.findByNomeUsuario(nomeUsuario);
		
		//verifica usuário e senha
		if (usuarioDoBanco != null
				&& usuarioDoBanco.getSenha().equals(senha)) {
			
			userDao.atualizarUltimoAcesso(usuarioDoBanco.getId(), new Date());
			
			//ok, salva o usuário na sessão e mostra entradas da agenda
			sessao.setAttribute("usuario", usuarioDoBanco);
			return new ModelAndView("redirect:/entradas");
			
		} else {
			
			//erro, mostra mensagem e fica na tela "home"
			return new ModelAndView("home")
				.addObject("erro", "Usuário ou senha inválidos");
			
		}
		
	}
	
	@RequestMapping("/logout")
	String logout(HttpSession sessao) {
		
		sessao.invalidate();
		return "redirect:/";
		
	}
	
}

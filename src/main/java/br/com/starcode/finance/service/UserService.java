package br.com.starcode.finance.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.starcode.finance.dao.UserDao;
import br.com.starcode.finance.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public User autenticarUsuario(String nomeUsuario) {
		User usuario = userDao.findByNomeUsuario(nomeUsuario);
		if (usuario == null) {
			throw new RuntimeException("Usuário não cadastrado!");
		}
		userDao.atualizarUltimoAcesso(usuario.getId(), new Date());
		return usuario;
	}
	
}

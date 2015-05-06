package br.com.starcode.finance.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.starcode.finance.dao.mapper.UserRowMapper;
import br.com.starcode.finance.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User findByNomeUsuario(String nomeUsuario) {
		try {
			return jdbcTemplate.queryForObject(
					"select * from usuario where nome_usuario = ?", 
					new UserRowMapper(), 
					nomeUsuario);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void atualizarUltimoAcesso(Integer id, Date data) {
		jdbcTemplate.update(
				"update usuario set ultimo_acesso = ? where id = ?", data, id);
	}

}

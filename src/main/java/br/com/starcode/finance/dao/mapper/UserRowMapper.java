package br.com.starcode.finance.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.starcode.finance.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user =  new User();
		user.setId(rs.getInt("id"));
		user.setNomeUsuario(rs.getString("nome_usuario"));
		user.setSenha(rs.getString("senha"));
		user.setNome(rs.getString("nome"));
		user.setUltimoAcesso(rs.getTimestamp("ultimo_acesso"));
		return user;
	}

}

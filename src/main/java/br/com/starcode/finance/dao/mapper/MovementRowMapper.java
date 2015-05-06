package br.com.starcode.finance.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.starcode.finance.model.Movement;
import br.com.starcode.finance.model.MovementType;


public class MovementRowMapper implements RowMapper<Movement> {

	@Override
	public Movement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movement movement = new Movement();
		movement.setId(rs.getInt("id"));
		movement.setHorario(rs.getTimestamp("movement_date"));
		movement.setDescricao(rs.getString("description"));
		movement.setPrioridade(MovementType.fromCode(rs.getString("type")));
		movement.setIdUsuario(rs.getInt("user_id"));
		return movement;
	}

}

package br.com.starcode.finance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.starcode.finance.dao.mapper.MovementRowMapper;
import br.com.starcode.finance.model.Movement;
import br.com.starcode.finance.util.DateUtil;

@Repository
public class MovementDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Movement findById(int id) {
		try {
			return jdbcTemplate.queryForObject(
					"select * from entrada where id = ?", 
					new MovementRowMapper(), 
					id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void insert(final Movement movement) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(
						"insert into movement (horario, descricao, prioridade, id_usuario) "
						+ "values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				ps.setTimestamp(1, DateUtil.getTimestamp(movement.getHorario()));
				ps.setString(2, movement.getDescricao());
				ps.setString(3, movement.getPrioridade().getCode());
				ps.setInt(4, movement.getIdUsuario());
				return ps;
			}
		}, keyHolder);
		movement.setId(keyHolder.getKey().intValue());
	}

	public int update(Movement movement) {
		return jdbcTemplate.update(
				"update movement set horario=?, descricao=?, prioridade=? where id=?",
				movement.getHorario(),
				movement.getDescricao(),
				movement.getPrioridade().getCode(),
				movement.getId());
	}

	public int delete(Integer id) {
		return jdbcTemplate.update("delete from movement where id=?", id);
	}

	public List<Movement> search() {
		/*
		return jdbcTemplate.query(
				"select * from entrada "
				+ "where (? is null or date(horario) >= date(?)) "
				+ "and (? is null or date(horario) <= date(?)) "
				+ "and (? is null or UPPER(descricao) like CONCAT('%', ? , '%')) "
				+ "order by " + ordem.getOrderBy(), 
				new MovementRowMapper(),
				filtro.getDe(), 
				filtro.getDe(),
				filtro.getAte(),
				filtro.getAte(),
				filtro.getDescricao(),
				filtro.getDescricao());
				*/
		return null;
	}
	
}

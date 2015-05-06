package br.com.starcode.finance.model;

import java.util.Date;

public class Movement {

	private Integer id;
	private Date horario;
	private String descricao;
	private MovementType prioridade;
	private Integer idUsuario;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getHorario() {
		return horario;
	}
	
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public MovementType getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(MovementType prioridade) {
		this.prioridade = prioridade;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}

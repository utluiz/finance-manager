package br.com.starcode.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.starcode.finance.dao.MovementDao;
import br.com.starcode.finance.model.Movement;

@Service
public class MovementService {

	@Autowired
	MovementDao movementDao;
	
	public Movement findById(Integer id) {
		return movementDao.findById(id);
	}
	
	public List<Movement> search() {
		return movementDao.search();
	}
	
	public void insert(Movement entrada) {
		validarEntrada(entrada);
		movementDao.insert(entrada);
	}
	
	public int update(Movement entrada) {
		if (entrada.getId() == null) {
			throw new RuntimeException("ID deve ser informado para atualizar!");
		}
		validarEntrada(entrada);
		int qtd = movementDao.update(entrada);
		if (qtd == 0) {
			throw new RuntimeException("Registro '" + entrada.getId() + "' não encontrado para !");
		}
		return qtd;
	}
	
	public int delete(Integer id) {
		int qtd = movementDao.delete(id);
		if (qtd == 0) {
			throw new RuntimeException("Registro '" + id + "' não encontrado para remoção!");
		}
		return qtd;
	}
	
	private void validarEntrada(Movement entrada) {
		if (entrada.getDescricao() == null || entrada.getDescricao().isEmpty()) {
			throw new RuntimeException("Descrição deve ser informada!");
		}
		if (entrada.getHorario() == null) {
			throw new RuntimeException("Horário deve ser informado!");
		}
		if (entrada.getIdUsuario() == null) {
			throw new RuntimeException("Usuário deve ser informado!");
		}
		if (entrada.getPrioridade() == null) {
			throw new RuntimeException("Prioridade deve ser informada!");
		}
	}
	
}

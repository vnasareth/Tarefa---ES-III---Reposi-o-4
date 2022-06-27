package controller;

import java.sql.SQLException;
import java.util.List;

import model.Funcionario;

public interface OperacoesController {

	public void salvar(Funcionario f) throws SQLException;
	public void modificar(Funcionario f) throws SQLException;
	public void remover(Funcionario f) throws SQLException;
	public Funcionario consultar(Funcionario f) throws SQLException;
	public List<Funcionario> listar() throws SQLException;
	
}

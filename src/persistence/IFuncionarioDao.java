package persistence;

import java.util.List;

import model.Funcionario;

public interface IFuncionarioDao {

	public void insert(Funcionario f);
	public void update(Funcionario f);
	public void delete(Funcionario f);
	public Funcionario selectOne(Funcionario f);
	public List<Funcionario> selectAll();
	
}

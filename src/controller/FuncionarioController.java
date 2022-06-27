package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Funcionario;
import persistence.FuncionarioDao;
import util.HibernateUtil;

public class FuncionarioController implements OperacoesController {

	@Override
	public void salvar(Funcionario f) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		FuncionarioDao funcionarioDao = new FuncionarioDao(sessionFactory);
		funcionarioDao.insert(f);
	}

	@Override
	public void modificar(Funcionario f) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		FuncionarioDao funcionarioDao = new FuncionarioDao(sessionFactory);
		funcionarioDao.update(f);
	}

	@Override
	public void remover(Funcionario f) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		FuncionarioDao funcionarioDao = new FuncionarioDao(sessionFactory);
		funcionarioDao.delete(f);
	}

	@Override
	public Funcionario consultar(Funcionario f) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		FuncionarioDao funcionarioDao = new FuncionarioDao(sessionFactory);
		f = funcionarioDao.selectOne(f);
		return f;
	}

	@Override
	public List<Funcionario> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		FuncionarioDao funcionarioDao = new FuncionarioDao(sessionFactory);
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios = funcionarioDao.selectAll();
		return funcionarios;
	}

}

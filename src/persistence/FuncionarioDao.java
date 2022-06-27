package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Funcionario;

public class FuncionarioDao implements IFuncionarioDao {

	private SessionFactory sf;
	
	public FuncionarioDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(f);
		transaction.commit();
	}

	@Override
	public void update(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(f);
		transaction.commit();
	}

	@Override
	public void delete(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(f);
		transaction.commit();
	}

	@Override
	public Funcionario selectOne(Funcionario f) {
		EntityManager entityManager = sf.createEntityManager();
		f = entityManager.find(Funcionario.class, f.getId());
		return f;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> selectAll() {
		String sql = "SELECT id, nome, salario, desconto_inss FROM funcionario";
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> funcionariosResultSet = query.getResultList();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for (Object[] obj : funcionariosResultSet) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId(Integer.parseInt(obj[0].toString()));
			funcionario.setNome(obj[1].toString());
			funcionario.setSalario(Float.parseFloat(obj[2].toString()));
			funcionario.setDescontoINSS(Float.parseFloat(obj[3].toString()));
			
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}

}

package view;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import controller.DescontoFaixa1;
import controller.FuncionarioController;
import controller.IDescontoINSS;
import model.Funcionario;
import util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		f1.setId(1);
		f1.setNome("Ingrid Santos");
		f1.setSalario(10500.00f);
		IDescontoINSS desc = new DescontoFaixa1();
		desc.proximoDesconto(f1);
		System.out.println(f1);
		
		Funcionario f2 = new Funcionario();
		f2.setId(2);
		f2.setNome("Caio Maia");
		f2.setSalario(4500.00f);
		desc.proximoDesconto(f2);
		System.out.println(f2);
		
		Funcionario f3 = new Funcionario();
		f3.setId(3);
		f3.setNome("Julia Raia");
		f3.setSalario(2800.00f);
		desc.proximoDesconto(f3);
		System.out.println(f3);
		
		Funcionario f4 = new Funcionario();
		f4.setId(4);
		f4.setNome("Bruna Xavier");
		f4.setSalario(1600.00f);
		desc.proximoDesconto(f4);
		System.out.println(f4);
		
		@SuppressWarnings("unused")
		SessionFactory sf = HibernateUtil.getSessionFactory();
		FuncionarioController fCont = new FuncionarioController();
		
		try {
			fCont.salvar(f1);
			fCont.salvar(f2);
			fCont.salvar(f3);
			fCont.salvar(f4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			f4.setSalario(1700f);
			desc.proximoDesconto(f4);
			fCont.modificar(f4);
			f4 = fCont.consultar(f4);
			System.out.println(f4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Funcionario> funcionarios = fCont.listar();
			funcionarios.forEach(f -> System.out.println(f));
			fCont.remover(f3);
			funcionarios = fCont.listar();
			funcionarios.forEach(f -> System.out.println(f));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}

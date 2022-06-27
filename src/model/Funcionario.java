package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@Column(name = "id")
	@NotNull
	private int id;
	
	@Column(name = "nome", length = 60)
	@NotNull
	private String nome;
	
	@Column(name = "salario")
	@NotNull
	private float salario;
	
	@Column(name = "desconto_inss")
	private float descontoINSS;
	
	public Funcionario() {
		this.descontoINSS = 0.0f;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public float getDescontoINSS() {
		return descontoINSS;
	}
	public void setDescontoINSS(float desconto) {
		this.descontoINSS = desconto;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Funcionário ");
		buffer.append(" | ID: " + id);
		buffer.append(" | Nome: " + nome);
		buffer.append(" | Salário Bruto: R$ " + salario);
		buffer.append(" | Desconto INSS: R$ " + descontoINSS);
		
		return buffer.toString();
	}
		
}

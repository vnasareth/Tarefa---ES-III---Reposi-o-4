package controller;

import model.Funcionario;

public interface IDescontoINSS {

	public float calculaDesconto(Funcionario f);
	public void proximoDesconto(Funcionario f);
	
}

package controller;

import model.Funcionario;

public class DescontoFaixa4 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0.0f;
		float valorMin = 3641.03f;
		float valorMax = 7087.22f;
		float porcentagem = 0.14f;
		if(f.getSalario() > valorMin && f.getSalario() <= valorMax) {
			desconto = (f.getSalario() - valorMin) * porcentagem;
		} else if(f.getSalario() > valorMax) {
			desconto = (valorMax - valorMin) * porcentagem;
		}
		return f.getDescontoINSS() + desconto;
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setDescontoINSS(calculaDesconto(f));
	}

}

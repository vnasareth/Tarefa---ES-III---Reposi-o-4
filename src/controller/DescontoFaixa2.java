package controller;

import model.Funcionario;

public class DescontoFaixa2 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0.0f;
		float valorMin = 1212.00f;
		float valorMax = 2427.35f;
		float porcentagem = 0.09f;
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
		
		DescontoFaixa3 descF3 = new DescontoFaixa3();
		descF3.proximoDesconto(f);
	}

}

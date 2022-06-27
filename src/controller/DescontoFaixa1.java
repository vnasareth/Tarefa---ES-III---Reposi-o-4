package controller;

import model.Funcionario;

public class DescontoFaixa1 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0.0f;
		float valorMax = 1212.00f;
		float porcentagem = 0.075f;
		if(f.getSalario() <= valorMax) {
			desconto = f.getSalario() * porcentagem;
		} else if(f.getSalario() > valorMax) {
			desconto = valorMax * porcentagem;
		}
		return f.getDescontoINSS() + desconto;
	}

	@Override
	public void proximoDesconto(Funcionario f) {
		f.setDescontoINSS(calculaDesconto(f));
		
		DescontoFaixa2 descF2 = new DescontoFaixa2();
		descF2.proximoDesconto(f);
	}

}

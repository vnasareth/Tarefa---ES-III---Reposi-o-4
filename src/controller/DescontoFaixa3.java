package controller;

import model.Funcionario;

public class DescontoFaixa3 implements IDescontoINSS {

	@Override
	public float calculaDesconto(Funcionario f) {
		float desconto = 0.0f;
		float valorMin = 2427.35f;
		float valorMax = 3641.03f;
		float porcentagem = 0.12f;
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
		
		DescontoFaixa4 descF4 = new DescontoFaixa4();
		descF4.proximoDesconto(f);
	}

}

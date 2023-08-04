package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.enums.DesempenhoEnum;

public class ReajusteService {

	public void reajusteAnual(Funcionario func, DesempenhoEnum desempenho) {
		BigDecimal percentual = desempenho.percentualReajuste();
		this.reajustarSalario(func, percentual);
	}
	
	public void reajustarSalario(Funcionario func, BigDecimal percentual) {
		BigDecimal reajuste = func.getSalario().multiply(percentual).setScale(2, RoundingMode.HALF_UP);
		func.setSalario(func.getSalario().add(reajuste));
	}
} 

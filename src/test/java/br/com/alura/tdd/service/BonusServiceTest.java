package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService bonusService = new BonusService();
		
		LocalDate data = LocalDate.now();
		BigDecimal salario = new BigDecimal("10500");
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Mayke", data, salario));
		
		Assert.assertEquals(new BigDecimal("0.00"), bonus);
	}

	@Test
	public void bonusDeveriaSerDe10PorcentoDoSalario() {
		BonusService bonusService = new BonusService();
		
		LocalDate data = LocalDate.now();
		BigDecimal salario = new BigDecimal("2500");
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Mayke", data, salario));
		
		Assert.assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	public void bonusDeveriaSer1000DoSalario10000() {
		BonusService bonusService = new BonusService();
		
		LocalDate data = LocalDate.now();
		BigDecimal salario = new BigDecimal("10000");
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Mayke", data, salario));
		
		Assert.assertEquals(new BigDecimal("1000.00"), bonus);
	}
}

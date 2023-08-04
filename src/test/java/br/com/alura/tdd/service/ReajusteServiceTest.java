package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.enums.DesempenhoEnum;

public class ReajusteServiceTest {

	@Test
	public void reajusteCasoODesepenhoSeja20PorCento() {
		ReajusteService service = new ReajusteService();
		
		LocalDate data = LocalDate.now();
		Funcionario func = new Funcionario("Mayke", data, new BigDecimal("100"));
		
		service.reajusteAnual(func, DesempenhoEnum.A);
		
		Assert.assertEquals(new BigDecimal("120.00"), func.getSalario());
	}
	
	@Test
	public void reajusteCasoODesepenhoSeja15PorCento() {
		ReajusteService service = new ReajusteService();
		
		LocalDate data = LocalDate.now();
		Funcionario func = new Funcionario("Mayke", data, new BigDecimal("100"));
		
		service.reajusteAnual(func, DesempenhoEnum.B);
		
		Assert.assertEquals(new BigDecimal("115.00"), func.getSalario());
	}
	
	@Test
	public void reajusteCasoODesepenhoSeja3PorCento() {
		ReajusteService service = new ReajusteService();
		
		LocalDate data = LocalDate.now();
		Funcionario func = new Funcionario("Mayke", data, new BigDecimal("100"));
		
		service.reajusteAnual(func, DesempenhoEnum.C);
		
		Assert.assertEquals(new BigDecimal("103.00"), func.getSalario());
	}
}

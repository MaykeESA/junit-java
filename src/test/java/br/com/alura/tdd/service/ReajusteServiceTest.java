package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.enums.DesempenhoEnum;

public class ReajusteServiceTest {

	private ReajusteService service;
	private LocalDate data;
	private Funcionario func;

	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.data = LocalDate.now();
		this.func = new Funcionario("Mayke", this.data, new BigDecimal("100"));
	}
	
	@Test
	public void reajusteCasoODesepenhoSeja20PorCento() {
		service.reajusteAnual(this.func, DesempenhoEnum.A);
		
		assertEquals(new BigDecimal("120.00"), func.getSalario());
	}
	
	@Test
	public void reajusteCasoODesepenhoSeja15PorCento() {
		service.reajusteAnual(func, DesempenhoEnum.B);
		
		assertEquals(new BigDecimal("115.00"), func.getSalario());
	}
	
	@Test
	public void reajusteCasoODesepenhoSeja3PorCento() {
		service.reajusteAnual(func, DesempenhoEnum.C);
		
		assertEquals(new BigDecimal("103.00"), func.getSalario());
	}
}

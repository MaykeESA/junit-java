package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private LocalDate data;
	private BigDecimal salario;
	private BonusService bonusService;

	public void inicializar(BigDecimal salario) {
		this.data = LocalDate.now();
		this.salario = salario;
		this.bonusService = new BonusService();
	}
	
	@Test
	public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		this.inicializar(new BigDecimal("10500"));
		
		assertThrows(IllegalArgumentException.class, 
				() -> bonusService.calcularBonus(new Funcionario("Mayke", this.data, this.salario)));
	}

	@Test
	public void bonusDeveriaSerDe10PorcentoDoSalario() {
		this.inicializar(new BigDecimal("2500"));
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Mayke", this.data, this.salario));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	public void bonusDeveriaSer1000DoSalario10000() {
		this.inicializar(new BigDecimal("10000"));		
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Mayke", this.data, this.salario));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}

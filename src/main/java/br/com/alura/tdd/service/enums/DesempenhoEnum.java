package br.com.alura.tdd.service.enums;

import java.math.BigDecimal;

public enum DesempenhoEnum {
	A {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.2");
		}
	},	
	B {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.15");
		}
	},	
	C {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.03");
		}
	};
	
	public abstract BigDecimal percentualReajuste();
}

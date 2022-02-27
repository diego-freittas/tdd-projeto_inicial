package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach // chama o método antes de CADA um dos métodos.
	public void inicializar() {
		service = new ReajusteService(); 
		funcionario = new Funcionario("Diego", LocalDate.now(), new BigDecimal("1000.00"));
	}

	@Test
	void quandoODesempenhoForADesejar_OReajusteDeveSerDeTresPorCento() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
 
	@Test
	void quandoODesempenhoForBom_OReajusteDeveSerDeQuizePorCento() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void quandoODesempenhoForOtimo_OReajusteDeveSerDeVintePorCento() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}

package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BalnearioTest {

	@Test
	public void elBalnearioNoTieneMuchaPlaya() {
		final Balneario balneario = new Balneario("Nombre par", 200, true, true);
		assertFalse(balneario.esDivertido());
	}

	@Test
	public void elBalnearioNoTieneUnMarPeligroso() {
		final Balneario balneario = new Balneario("Nombre par", 400, false, true);
		assertFalse(balneario.esDivertido());
	}

	@Test
	public void elBalnearioEsDivertido() {
		final Balneario balneario = new Balneario("Nombre par", 400, true, true);
		assertTrue(balneario.esDivertido());
	}

}

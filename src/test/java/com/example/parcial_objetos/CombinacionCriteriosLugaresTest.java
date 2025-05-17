package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CombinacionCriteriosLugaresTest {

	final PreferenciaVacaciones preferencia = new CombinacionCriteriosLugares(
			new PreferenciaVacaciones[] { new LugaresTranquilos(), new LugaresRaros() });
	final Persona persona = new Persona(preferencia, 1000000);

	@Test
	public void elLugarNoCoincideConNingunaPreferencia() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 30);
		assertFalse(persona.tienePreferencia(ciudad));
	}

	@Test
	public void elLugarCoincideConAlgunaPreferencia() {
		final Ciudad ciudad = new Ciudad("Nombre letras par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 30);
		assertTrue(persona.tienePreferencia(ciudad));
	}
}

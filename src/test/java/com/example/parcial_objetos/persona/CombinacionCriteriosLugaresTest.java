package com.example.parcial_objetos.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import com.example.parcial_objetos.lugar.Ciudad;

public class CombinacionCriteriosLugaresTest {

	private final PreferenciaVacaciones preferencia = new CombinacionCriteriosLugares(
			new HashSet<PreferenciaVacaciones>(Arrays.asList(new LugaresTranquilos(), new LugaresRaros())));
	private final Persona persona = new Persona(preferencia, 1000000);

	@Test
	public void lasPreferenciasNoSonLasMismas() {
		final PreferenciaVacaciones otrasPreferencias = new CombinacionCriteriosLugares(
				new HashSet<PreferenciaVacaciones>(Arrays.asList(new LugaresTranquilos(), new LugaresDivertidos())));
		assertNotEquals(preferencia, otrasPreferencias);
	}

	@Test
	public void lasPreferenciasSonLasMismas() {
		final PreferenciaVacaciones otrasPreferencias = new CombinacionCriteriosLugares(
				new HashSet<PreferenciaVacaciones>(
						Arrays.asList(new LugaresRaros(), new LugaresTranquilos(), new LugaresTranquilos())));
		assertEquals(preferencia, otrasPreferencias);
	}

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

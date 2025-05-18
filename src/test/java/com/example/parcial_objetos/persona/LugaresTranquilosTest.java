package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LugaresTranquilosTest {

	final Persona persona = new Persona(new LugaresTranquilos(), 1000000);

	@Test
	public void laCiudadNoEsTranquila() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 30);
		assertFalse(persona.tienePreferencia(ciudad));
	}

	@Test
	public void laCiudadEsTranquila() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 15);
		assertTrue(persona.tienePreferencia(ciudad));
	}

	@Test
	public void elPuebloNoEsTranquilo() {
		final Pueblo pueblo = new Pueblo("Nombre par", 100, 1750, "Rio Negro");
		assertFalse(persona.tienePreferencia(pueblo));
	}

	@Test
	public void elPuebloEsTranquilo() {
		final Pueblo pueblo = new Pueblo("Nombre par", 100, 1750, "La Pampa");
		assertTrue(persona.tienePreferencia(pueblo));
	}

	@Test
	public void elBalnearioNoEsTranquilo() {
		final Balneario balneario = new Balneario("Nombre par", 400, true, true);
		assertFalse(persona.tienePreferencia(balneario));
	}

	@Test
	public void elBalnearioEsTranquilo() {
		final Balneario balneario = new Balneario("Nombre par", 400, true, false);
		assertTrue(persona.tienePreferencia(balneario));
	}

}

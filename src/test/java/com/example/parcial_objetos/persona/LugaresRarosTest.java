package com.example.parcial_objetos.persona;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.parcial_objetos.lugar.Ciudad;

public class LugaresRarosTest {

	private final Persona persona = new Persona(new LugaresRaros(), 1000000);

	@Test
	public void elLugarNoEsRaro() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" },
				20);
		assertFalse(persona.tienePreferencia(ciudad));
	}

	@Test
	public void elLugarEsRaro() {
		final Ciudad ciudad = new Ciudad("Nombre letras par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" },
				20);
		assertTrue(persona.tienePreferencia(ciudad));
	}
}

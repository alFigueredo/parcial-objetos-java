package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CiudadTest {

	@Test
	public void laCiudadPoseePocasAtracciones() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000, new String[] { "Fuente", "Plaza", "Obelisco" }, 20);
		assertFalse(ciudad.lugarDivertido());
	}

	@Test
	public void laCiudadPoseePocosHabitantes() {
		final Ciudad ciudad = new Ciudad("Nombre par", 50000, new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" },
				20);
		assertFalse(ciudad.lugarDivertido());
	}

	@Test
	public void laCiudadEsDivertida() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 20);
		assertTrue(ciudad.lugarDivertido());
	}

}

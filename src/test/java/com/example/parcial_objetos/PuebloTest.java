package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PuebloTest {

	@Test
	public void elPuebloNoEsDivertido() {
		final Pueblo pueblo = new Pueblo("Nombre par", 100, 1850, "Rio Negro");
		assertFalse(pueblo.lugarDivertido());
	}

	@Test
	public void elPuebloEsViejo() {
		final Pueblo pueblo = new Pueblo("Nombre par", 100, 1750, "Rio Negro");
		assertTrue(pueblo.lugarDivertido());
	}

	@Test
	public void elPuebloEsDelLitoral() {
		final Pueblo pueblo = new Pueblo("Nombre par", 100, 1850, "Corrientes");
		assertTrue(pueblo.lugarDivertido());
	}

}

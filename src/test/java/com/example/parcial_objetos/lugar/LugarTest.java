package com.example.parcial_objetos.lugar;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class LugarTest {

	@Test
	public void elLugarNuncaEsDivertido() {
		final Ciudad lugar = new Ciudad("Impar", 200000, new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 20);
		assertFalse(lugar.lugarDivertido());
	}

}

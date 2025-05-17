package com.example.parcial_objetos;

public class LugaresDivertidos implements PreferenciaVacaciones {

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return lugar.lugarDivertido();
	}

}

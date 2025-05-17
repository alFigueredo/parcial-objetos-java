package com.example.parcial_objetos;

public class LugaresRaros implements PreferenciaVacaciones {

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return lugar.nombreConMuchasLetras();
	}

}

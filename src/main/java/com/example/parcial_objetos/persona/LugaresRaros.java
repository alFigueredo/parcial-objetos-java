package com.example.parcial_objetos.persona;

import com.example.parcial_objetos.lugar.Lugar;

public class LugaresRaros implements PreferenciaVacaciones {

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return lugar.nombreConMuchasLetras();
	}

}

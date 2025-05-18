package com.example.parcial_objetos;

public class LugaresTranquilos implements PreferenciaVacaciones {

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return lugar.lugarTranquilo();
	}

}

package com.example.parcial_objetos;

public abstract class Lugar {

	private final String nombre;

	public Lugar(String nombre) {
		this.nombre = nombre;
	}

	public boolean lugarDivertido() {
		return this.nombreConCantidadParDeLetras() && this.esDivertido();
	}

	public boolean nombreConCantidadParDeLetras() {
		return this.nombre.length() % 2 == 0;
	}

	abstract boolean esDivertido();

	public boolean nombreConMuchasLetras() {
		return this.nombre.length() > 10;
	}

	abstract boolean lugarTranquilo();

}

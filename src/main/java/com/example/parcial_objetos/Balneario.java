package com.example.parcial_objetos;

public class Balneario extends Lugar {

	private final int metrosDePlayaPromedio;
	private final boolean marPeligroso;
	private final boolean tienePeatonal;

	public Balneario(String nombre, int metrosDePlayaPromedio, boolean marPeligroso, boolean tienePeatonal) {
		super(nombre);
		this.metrosDePlayaPromedio = metrosDePlayaPromedio;
		this.marPeligroso = marPeligroso;
		this.tienePeatonal = tienePeatonal;
	}

	public boolean esDivertido() {
		return this.muchaPlaya() && this.marPeligroso;
	}

	private boolean muchaPlaya() {
		return metrosDePlayaPromedio > 300;
	}

	public boolean lugarTranquilo() {
		return !this.tienePeatonal;
	}

}

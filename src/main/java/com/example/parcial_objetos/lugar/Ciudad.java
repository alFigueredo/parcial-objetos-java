package com.example.parcial_objetos;

public class Ciudad extends Lugar {

	private final int cantidadHabitantes;
	private final String[] atraccionesTuristicas;
	private final int decibelesPromedio;

	public Ciudad(String nombre, int cantidadHabitantes, String[] atraccionesTuristicas, int decibelesPromedio) {
		super(nombre);
		this.cantidadHabitantes = cantidadHabitantes;
		this.atraccionesTuristicas = atraccionesTuristicas;
		this.decibelesPromedio = decibelesPromedio;
	}

	public boolean esDivertido() {
		return this.muchasAtraccionesTuristicas() && this.muchosHabitantes();
	}

	private boolean muchasAtraccionesTuristicas() {
		return atraccionesTuristicas.length > 3;
	}

	private boolean muchosHabitantes() {
		return cantidadHabitantes > 100000;
	}

	public boolean lugarTranquilo() {
		return this.lugarConPocoRuido();
	}

	private boolean lugarConPocoRuido() {
		return decibelesPromedio < 20;
	}

}

package com.example.parcial_objetos;

import java.util.Arrays;

public class Pueblo extends Lugar {

	private final int extension;
	private final int fundacion;
	private final String provincia;

	public Pueblo(String nombre, int extension, int fundacion, String provincia) {
		super(nombre);
		this.extension = extension;
		this.fundacion = fundacion;
		this.provincia = provincia;
	}

	public int getExtension() {
		return extension;
	}

	public boolean esDivertido() {
		return this.puebloViejo() || this.esDelLitoral();
	}

	private boolean puebloViejo() {
		return fundacion < 1800;
	}

	private boolean esDelLitoral() {
		return Arrays.stream(new String[] { "Entre Ríos", "Corrientes", "Misiones" })
				.anyMatch((provinciaLitoral) -> provinciaLitoral.equals(provincia));
	}

	public boolean lugarTranquilo() {
		return this.esDeLaPampa();
	}

	private boolean esDeLaPampa() {
		return provincia.equals("La Pampa");
	}
}

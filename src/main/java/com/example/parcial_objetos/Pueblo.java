package com.example.parcial_objetos;

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
		final String[] provinciasLitoral = { "Entre Ríos", "Corrientes", "Misiones" };
		for (String provincia : provinciasLitoral) {
			if (this.provincia.equals(provincia))
				return true;
		}
		return false;
	}

	public boolean lugarTranquilo() {
		return this.esDeLaPampa();
	}

	private boolean esDeLaPampa() {
		return this.provincia.equals("La Pampa");
	}
}

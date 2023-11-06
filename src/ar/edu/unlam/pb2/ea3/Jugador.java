package ar.edu.unlam.pb2.ea3;

import java.util.Objects;

public class Jugador {
	
	private Integer dorsal;
	private String nombre;
	private Integer precio;

	public Jugador(Integer dorsal, String nombre, Integer precio) {
		this.setDorsal(dorsal);
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
		
	public Integer getDorsal() {
		return dorsal;
	}

	private void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	private void setPrecio(Integer precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}

}

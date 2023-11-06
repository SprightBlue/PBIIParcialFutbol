package ar.edu.unlam.pb2.ea3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EquipoDeFutbol{
	
	private String nombre;
	private TreeSet<Jugador> jugadores;

	public EquipoDeFutbol(String nombre) {
		this.setNombre(nombre);
		this.jugadores = new TreeSet<Jugador>(new Comparator<Jugador>() {

			@Override
			public int compare(Jugador jugador1, Jugador jugador2) {
				return jugador1.getNombre().compareTo(jugador2.getNombre());
			}
			
		});
	}
	
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public TreeSet<Jugador> getJugadores() {
		return jugadores;
	}

	/*
	 * La capacidad m�xima de un equipo es 23. Cualquier intento de agregar m�s
	 * jugadores generar� una excepci�n (CapacidadMaximaException). Adem�s, no
	 * deber� permitir duplicar Jugadores (JugadorDuplicadoException).
	 */
	public void agregarJugador(Jugador jugador) throws CapacidadMaximaException, JugadorDuplicadoException {
		if(this.jugadores.size()==23) {
			throw new CapacidadMaximaException();
		}
		if(this.jugadores.contains(jugador)) {
			throw new JugadorDuplicadoException();
		}
		this.jugadores.add(jugador);
	}

	/*
	 * Permite cambiar cualquier jugador. Un intento de cambiar un jugador no
	 * presente en el equipo generar� una excepci�n
	 * (JugadoreInexistenteException).
	 */
	public Boolean cambiarJugador(Jugador saliente, Jugador entrante) throws JugadoreInexistenteException{
		if(!this.jugadores.contains(saliente)) {
			throw new JugadoreInexistenteException();
		}
		this.jugadores.remove(saliente);
		this.jugadores.add(entrante);
		return true;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNombreDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorNombreDeJugador = new TreeSet<Jugador>(new Comparator<Jugador>() {

			@Override
			public int compare(Jugador jugador1, Jugador jugador2) {
				return jugador1.getNombre().compareTo(jugador2.getNombre());
			}
			
		}) ;
		Iterator<Jugador> iterador = this.jugadores.iterator();
		while(iterador.hasNext()) {
			plantelOrdenadoPorNombreDeJugador.add(iterador.next());
		}
		return plantelOrdenadoPorNombreDeJugador;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorPrecioDeCompraDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorPrecioDeCompraDeJugador = new TreeSet<Jugador>(new Comparator<Jugador>() {

			@Override
			public int compare(Jugador jugador1, Jugador jugador2) {
				return jugador1.getPrecio().compareTo(jugador2.getPrecio());
			}
			
		});
		Iterator<Jugador> iterador = this.jugadores.iterator();
		while(iterador.hasNext()) {
			plantelOrdenadoPorPrecioDeCompraDeJugador.add(iterador.next());
		}
		return plantelOrdenadoPorPrecioDeCompraDeJugador;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNumeroDeCamisetaDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorNumeroDeCamisetaDeJugador = new TreeSet<Jugador>(new Comparator<Jugador>() {

			@Override
			public int compare(Jugador jugador1, Jugador jugador2) {
				return jugador1.getDorsal().compareTo(jugador2.getDorsal());
			}
			
		});
		Iterator<Jugador> iterador = this.jugadores.iterator();
		while(iterador.hasNext()) {
			plantelOrdenadoPorNumeroDeCamisetaDeJugador.add(iterador.next());
		}
		return plantelOrdenadoPorNumeroDeCamisetaDeJugador;
	}

}

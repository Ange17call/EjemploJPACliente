package com.distribuida.interfaces;

import java.util.List;

public interface Servicio {
	public List<Persona> listar();
	public void insertarPersona(Persona persona);
	public void insertarDireccion(Direccion direccion);
	public void eliminarPersona( int id );
	public void eliminarDireccion( int id );
	public Persona buscarPersona( int id );
	public Direccion buscarDireccion( int id );
	public int buscarDireccionNombre(String calleprimaria, String callesecundaria, int numero );
	public void actualizarPersona( Persona p );
	public void actualizarDireccion( Direccion p );
	public String prueba();

}

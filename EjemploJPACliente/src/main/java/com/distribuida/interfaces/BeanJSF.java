package com.distribuida.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.jsf.FacesContextUtils;

@ManagedBean
@RequestScope
public class BeanJSF {
	private DataModel<Persona> personaModel; 
	private Servicio servicio;
	private int id;
	private String nombre;
	private String calleprimaria;
	private String callesecundaria;
	private int numero;
	private String telefono;
	
	public BeanJSF(){
		
	}
	
	public BeanJSF(int id, String nombre, String calleprimaria,String callesecundaria, int numero,  String telefono){
	this.id=id;
	this.nombre=nombre;
	this.calleprimaria=calleprimaria;
	this.callesecundaria=callesecundaria;
	this.numero=numero;
	this.telefono=telefono;
		
	}
	
	
	@PostConstruct
	protected void init() {
		
		ApplicationContext context = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());

		servicio = context.getBean(Servicio.class);
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCalleprimaria() {
		return calleprimaria;
	}



	public void setCalleprimaria(String calleprimaria) {
		this.calleprimaria = calleprimaria;
	}



	public String getCallesecundaria() {
		return callesecundaria;
	}



	public void setCallesecundaria(String callesecundaria) {
		this.callesecundaria = callesecundaria;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public void setPersonaModel(DataModel<Persona> personaModel) {
		this.personaModel = personaModel;
	}

	public DataModel<Persona> getPersonaModel() {
		personaModel= new ListDataModel<Persona>(listarPersonas());
		return personaModel;
	}

	public List<Persona> listarPersonas(){
		List<Persona> personas = new ArrayList<>();
		personas = servicio.listar();
		return personas;
	}
	public String guardar(){
		Direccion dir = new Direccion();
		int n;
		n = servicio.buscarDireccionNombre(calleprimaria, callesecundaria, numero);
		if(n==-1){
			dir.setCalleprimaria(calleprimaria);
			dir.setCallesecundaria(callesecundaria);
			dir.setNumero(numero);
			servicio.insertarDireccion(dir);
		}else{
			dir=servicio.buscarDireccion(3);
		}
						
		Persona per = new Persona();
		per.setNombre(nombre);
		per.setDireccion(dir);
		per.setTelefono(telefono);
		
		servicio.insertarPersona(per);
		
		return "index";
	}
	public String actualizarBean(){
		
		return "actualizar";
	}
	public String confirmarActualizar(){
		Persona persona=new Persona();
		persona=servicio.buscarPersona(id);
		id=persona.getId();
		nombre=persona.getNombre();
		calleprimaria=persona.getDireccion().getCalleprimaria();
		callesecundaria=persona.getDireccion().getCallesecundaria();
		numero=persona.getDireccion().getNumero();
		telefono=persona.getTelefono();
	
		return "confirmarActualizar";
	}
	public String confActualizar(){
		Direccion dir = new Direccion();
		int n;
		n = servicio.buscarDireccionNombre(calleprimaria, callesecundaria, numero);
		if(n==-1){
			dir.setCalleprimaria(calleprimaria);
			dir.setCallesecundaria(callesecundaria);
			dir.setNumero(numero);
			servicio.actualizarDireccion(dir);
		}else{
			dir=servicio.buscarDireccion(3);
		}
						
		Persona per = new Persona();
		per.setId(id);
		per.setNombre(nombre);
		per.setDireccion(dir);
		per.setTelefono(telefono);
		
		servicio.actualizarPersona(per);
	
		return "actualizar";
	}
	
}

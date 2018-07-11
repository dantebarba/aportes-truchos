package com.github.dantebarba.aportestruchos.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.dantebarba.aportestruchos.domain.generics.EntidadBase;

public class Aporte extends EntidadBase {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellido;
	private String dni;
	private TipoOperacion tipoOperacion = TipoOperacion.DEPOSITO;
	private double importe;
	
	@Override
	public Long getId() {
		return this.id;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

package com.github.dantebarba.aportestruchos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.dantebarba.aportestruchos.domain.generics.EntidadBase;

@Entity
@Table(name = "aportes")
public class Aporte extends EntidadBase {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	private TipoOperacion tipo = TipoOperacion.DEPOSITO;
	private double importe;

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public TipoOperacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacion tipoOperacion) {
		this.tipo = tipoOperacion;
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

	@Override
	public Long getId() {
		return this.id;
	}

}

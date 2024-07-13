package com.uce.edu.pw.api.repository.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;

public class EstudianteTO implements Serializable{
	
	private static final long serialVersionUID = 436975337931482752L;

	//Debe tener en su mayoria los mismo campos de Estudiante pero no siempre
	//es necesario
	
    private Integer id;
	

	private String nombre;
	
	
	private String apellido;
	
	
	private LocalDateTime fechaNacimiento;
			
	private String genero;
	
	private List<MateriaTO> materias;

	
	//SET y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<MateriaTO> getMaterias() {
		return materias;
	}

	public void setMaterias(List<MateriaTO> materias) {
		this.materias = materias;
	}
	
	

}

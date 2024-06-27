package com.uce.edu.pw.api.repository;

import com.uce.edu.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	//CRUD
	public Estudiante seleccionar(Integer id);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public void insertar(Estudiante estudiante);

}

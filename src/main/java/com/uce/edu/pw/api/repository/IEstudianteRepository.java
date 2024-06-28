package com.uce.edu.pw.api.repository;

import com.uce.edu.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	//CRUD
	 Estudiante seleccionar(Integer id);
	void actualizar(Estudiante estudiante);
	 void eliminar(Integer id);
	 void insertar(Estudiante estudiante);

}

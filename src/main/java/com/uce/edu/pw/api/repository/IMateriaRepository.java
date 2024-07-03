package com.uce.edu.pw.api.repository;

import com.uce.edu.pw.api.repository.modelo.Estudiante;
import com.uce.edu.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
	
	void insertar(Materia materia);
	void actualizar(Materia materia);
	Materia seleccionar(Integer id);
	void eliminar(Integer id);

}

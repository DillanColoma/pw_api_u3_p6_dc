package com.uce.edu.pw.api.repository;

import java.util.List;

import com.uce.edu.pw.api.modelo.Estudiante;
import com.uce.edu.pw.api.modelo.Materia;

public interface IMateriaRepository {
	
	void insertar(Materia materia);
	void actualizar(Materia materia);
	Materia seleccionar(Integer id);
	void eliminar(Integer id);
	public List<Materia> seleccionarPorIdEstudiante(Integer id);

}

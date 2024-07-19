package com.uce.edu.pw.api.repository;

import java.util.List;

import com.uce.edu.pw.api.modelo.Estudiante;

public interface IEstudianteRepository {

	// CRUD
	Estudiante seleccionar(Integer id);

	void actualizar(Estudiante estudiante);

	void eliminar(Integer id);

	void insertar(Estudiante estudiante);

	List<Estudiante> seleccionarPorGenero(String genero);

	List<Estudiante> seleccionarTodos();

	//NUEVA FUNCIONALIDAD
	Estudiante seleccionarPorCedula(String cedula);
	int eliminarPorCedula(String cedula);
	
	int actualizarPorCedula(String cedula);

}

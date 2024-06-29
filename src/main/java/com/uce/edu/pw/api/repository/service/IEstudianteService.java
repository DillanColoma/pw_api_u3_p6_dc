package com.uce.edu.pw.api.repository.service;

import java.util.List;

import com.uce.edu.pw.api.repository.modelo.Estudiante;

public interface IEstudianteService {
	public Estudiante buscar(Integer id);
	public void actualizar(Estudiante estudiante);
	public void borrar(Integer id);
	public void registrar(Estudiante estudiante);
	 List<Estudiante> seleccionarPorGenero(String genero);


}

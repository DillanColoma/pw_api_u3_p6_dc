package com.uce.edu.pw.api.service;

import java.util.List;

import com.uce.edu.pw.api.modelo.Materia;
import com.uce.edu.pw.api.service.to.MateriaTO;

public interface IMateriaService {
	
	void agregar(Materia materia);
	void modificar(Materia materia);
	Materia buscar(Integer id);
	void borrar(Integer id);
	public List<MateriaTO> buscarPorIdEstudiante(Integer id);

}

package com.uce.edu.pw.api.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.pw.api.repository.IMateriaRepository;
import com.uce.edu.pw.api.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public void agregar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}

	@Override
	public void modificar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizar(materia);
	}

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.eliminar(id);
	}
	
	
	

}

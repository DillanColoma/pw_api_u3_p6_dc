package com.uce.edu.pw.api.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.pw.api.repository.IEstudianteRepository;
import com.uce.edu.pw.api.repository.modelo.Estudiante;
import com.uce.edu.pw.api.repository.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
		
	}

	@Override
	public void registrar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		// TODO Auto-generated method stub
		List<Estudiante> lista=  this.estudianteRepository.seleccionarPorGenero(genero);
		return lista;
	}
	
	public EstudianteTO convertir(Estudiante estu) {
		EstudianteTO esTo= new EstudianteTO();
		esTo.setId(estu.getId());
		esTo.setNombre(estu.getNombre());
		esTo.setApellido(estu.getApellido());
		esTo.setGenero(estu.getGenero());
		esTo.setFechaNacimiento(estu.getFechaNacimiento());
		
		return esTo;
		
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estu= this.estudianteRepository.seleccionar(id);
		return this.convertir(estu);
	}

}

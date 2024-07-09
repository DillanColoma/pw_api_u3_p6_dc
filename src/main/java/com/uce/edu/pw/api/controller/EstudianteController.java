package com.uce.edu.pw.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.pw.api.repository.modelo.Estudiante;
import com.uce.edu.pw.api.repository.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {
	
	//Se inyecta la capa Service
	@Autowired
	private IEstudianteService estudianteService;
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	//Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/
	@PostMapping
	public void guardar(@RequestBody Estudiante est) {
		this.estudianteService.registrar(est);
				
	}

	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	//Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		this.estudianteService.actualizar(est);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	//Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	//En el postman ya no lleva el id
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id){
		est.setId(id);
		Estudiante est2= this.estudianteService.buscar(est.getId());
		if(est.getNombre()!=null) {
			est2.setNombre(est.getNombre());
		}
		if(est.getApellido()!=null) {
			est2.setApellido(est.getApellido());
			
		}
		if(est.getFechaNacimiento()!=null){
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}
				
		this.estudianteService.actualizar(est2);
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2 puedo enviar cualquier tipo de dato
	//Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) { //el tipo de dato que voy a ocupar en este caso es un id por 
	                                 //por eso es un Integer y le pongo la anotacion @PathVariable
		
		this.estudianteService.borrar(id);
		
	}
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	//Nivel 1 http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}

	@GetMapping(path = "/genero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero){
		
		List<Estudiante> lista= this.estudianteService.seleccionarPorGenero(genero);
		return lista;
	}
	
	//http://localhost:8082/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=21
	@GetMapping(path = "/buscarPorGenero")
	//El elemento de fitrado viene en el arguemeto con la anotacion @RequestParam
	public List<Estudiante> buscarPorGenero(@RequestParam String genero,@RequestParam Integer edad){
		System.out.println("Edad "+ edad);
		List<Estudiante> lista = this.estudianteService.seleccionarPorGenero(genero);
		return lista;
		
	}

		
	//http://localhost:8082/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=HolaMundo
	@GetMapping(path = "/buscarMixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		System.out.println("Id " +id);
		System.out.println("Prueba "+prueba);
		return this.estudianteService.buscar(id);
	}
	
	//EL END POINT NO TIENE QUE SE AMBIGUO, EN DARSE ESTE CASO ME DA ERRORES AMBIGUOS MAPPING
}

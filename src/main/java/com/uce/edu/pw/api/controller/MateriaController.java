package com.uce.edu.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.pw.api.modelo.Materia;
import com.uce.edu.pw.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias
	@PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materia> agregar(@RequestBody Materia materia) {
		this.iMateriaService.agregar(materia);
		
		HttpHeaders cabeceraPost= new HttpHeaders();
		cabeceraPost.add("mensaje_201", "Corresponde a la inserción de un recurso");
		cabeceraPost.add("valor", "Materia ingresada con éxito");
		return new ResponseEntity<>(materia ,cabeceraPost,201); 
		
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias/{id}
	@PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> modificar(@RequestBody Materia materia,@PathVariable Integer id) {
		 Materia mater = iMateriaService.buscar(id);
	        if (mater != null) {
	            materia.setId(id);
	            iMateriaService.modificar(materia);
	            
	        }
	        
	        HttpHeaders cabeceraPut= new HttpHeaders();
			cabeceraPut.add("mensaje_238", "Corresponde a la actualización de un recurso");
			cabeceraPut.add("valor", "Materia actualizado");
			return new ResponseEntity<>(mater,cabeceraPut,238);
	      
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias/{id}
	@PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> modificarParcial(@RequestBody Materia materia,@PathVariable Integer id) {
		materia.setId(id);
		Materia materia2=this.iMateriaService.buscar(materia.getId());
		if(materia.getNombre()!=null) {
			materia2.setNombre(materia.getNombre());
		}
		if(materia.getPrecio()!=null) {
			materia2.setPrecio(materia.getPrecio());	
		}
		if(materia.getProfesor()!=null) {
			materia2.setProfesor(materia.getProfesor())	;
		}
		
		this.iMateriaService.modificar(materia2);
		HttpHeaders cabeceraPatch= new HttpHeaders();
		cabeceraPatch.add("mensaje_239", "Corresponde a la actualización parcial de un recurso");
		cabeceraPatch.add("valor", "Materia actualizado parcialmente");
		//return ResponseEntity.status(239).body(est2);
		return new ResponseEntity<>(materia2,cabeceraPatch,239);
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.iMateriaService.borrar(id);
		HttpHeaders cabeceraDelete= new  HttpHeaders();
		cabeceraDelete.add("mensaje_240", "Corresponde a la eliminación del recurso");
		cabeceraDelete.add("valor", "MAteria eliminada");
		return new ResponseEntity<>("Eliminado correctamente",cabeceraDelete,240);
		
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias/{id}
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materia> encontrar(@PathVariable Integer id) {
		
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Materia escontrada");
		return new ResponseEntity<>( this.iMateriaService.buscar(id),cabeceras,236);
		
	}

}

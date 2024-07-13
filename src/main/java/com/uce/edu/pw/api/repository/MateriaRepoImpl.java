package com.uce.edu.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.pw.api.repository.modelo.Estudiante;
import com.uce.edu.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepoImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);

	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public Materia seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id=:id",
				Materia.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}

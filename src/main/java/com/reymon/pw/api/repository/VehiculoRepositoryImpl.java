package com.reymon.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.reymon.pw.api.repository.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public Vehiculo search(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> query = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :placa ", Vehiculo.class)
				.setParameter("placa", placa);

		return query.getSingleResult();

	}

	@Override
	public List<Vehiculo> searchAll() {
		// TODO Auto-generated method stub

		TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);

		return query.getResultList();
	}

	@Override
	public void delete(String placa) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.search(placa));
	}

	@Override
	public void update(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

}

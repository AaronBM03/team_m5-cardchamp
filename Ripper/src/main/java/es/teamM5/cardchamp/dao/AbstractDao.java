package es.teamM5.cardchamp.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import es.teamM5.cardchamp.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public abstract class AbstractDao<T> implements Dao<T> {

	private EntityManager em = EntityManagerUtil.getEntityManager();
	private Class<T> clazz;

	@Override
	public Optional<T> get(long id) {
		// Finds a certain class through an id
		return Optional.ofNullable(em.find(clazz, id));
	}

	@Override
	public List<T> getAll() {
		String qlString = "FROM " + clazz.getName();
		Query query = em.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	/**
	 * In the persistence layer (that which is going to persist aka. the database
	 * layer), we are declaring a new persisting object (aka. inserting data into my
	 * DB).
	 */
	public void save(T t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	public void update(T t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
	}

	@Override
	public void delete(T t) {
		executeInsideTransaction(entityManager -> entityManager.remove(t));
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	/*
	 * Executes the operation passed as argument as a TRANSACTION, meaning that the
	 * operation must be executed atomically, meaning either fully or not at all,
	 * making a rollback if the operation fails at any moment.
	 */
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			throw re;
		}
	}
}
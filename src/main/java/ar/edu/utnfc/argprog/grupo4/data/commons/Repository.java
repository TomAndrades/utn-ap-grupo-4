package ar.edu.utnfc.argprog.grupo4.data.commons;

import java.util.List;

import ar.edu.utnfc.argprog.grupo4.commons.ReflectionUtil;
import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.hibernate.HibernateException;


/**
 * Clase base para los Daos que utilicen JPA
 *
 * @param <E> Tipo de la entidad asociada
 * @param <K> Tipo de la clave primaria de la entidad asociada
 * @author Felipe
 */
public abstract class Repository<E extends DalEntity, K> implements RepositoryInterface<E, K> {

    protected EntityManager entityManager = LocalEntityManagerProvider.getEntityManager();

    private final Class<E> entityClass;

    public Repository() {
        entityClass = ReflectionUtil.getGenericTypeClass(getClass());

    }

    protected Class<E> getEntityClass() {
        return entityClass;
    }

    @Override
    public E create(E pData) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(pData);
            entityManager.flush();

            entityManager.getTransaction().commit();

        }
        catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
            throw new TechnicalException(ex);
        }

        return pData;
    }

    @Override
    public void update(E pData) {
        try {
            entityManager.getTransaction().begin();
            E managed = entityManager.merge(pData);
            entityManager.persist(managed);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
            throw new TechnicalException(ex);
        }
    }

    @Override
    public void delete(K pKey) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(retrieve(pKey));
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (HibernateException ex) {
            entityManager.getTransaction().rollback();
            throw new TechnicalException(ex);
        }
    }

    @Override
    public E retrieve(K pKey) {
        return entityManager.find(getEntityClass(), pKey);
    }

    @Override
    public List<E> findAll() {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createQuery("SELECT e FROM " + className + " e");

            return query.getResultList();
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }

    }

    public List<E> findByFilter(String filter) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery(className + ".findByFilter")
                    .setParameter(":filter", filter);

            return query.getResultList();
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }

    }

}

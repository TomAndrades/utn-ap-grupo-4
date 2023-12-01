package ar.edu.utnfc.argprog.data.repositories;


import ar.edu.utnfc.argprog.entities.EspecialidadTecnicoEntity;
import ar.edu.utnfc.argprog.sakila.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.sakila.data.commons.Repository;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;

public class EspecialidadTecnicoRepository extends Repository<EspecialidadTecnicoEntity, Integer> {

    public List<EspecialidadTecnicoEntity> findByEspecialidad(int idEspecialidad) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createQuery("SELECT t FROM EspecialidadTecnicoEntity t WHERE t.especialidadEntity = " + idEspecialidad);

            return query.getResultList();
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }

    }
    
  
}


package ar.edu.utnfc.argprog.data.repositories;


import ar.edu.utnfc.argprog.entities.IncidenteEntity;
import ar.edu.utnfc.argprog.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.data.commons.Repository;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;

public class IncidenteRepository extends Repository<IncidenteEntity, Integer> {

    public List<IncidenteEntity> findByTecnico(int idTecnico) {
        try {

            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("IncidenteEntity.findByTecnico")
                    .setParameter("idTecnico", idTecnico);

            return query.getResultList();
            
           
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }
    }
}
    
package ar.edu.utnfc.argprog.grupo4.data.repositories;


import ar.edu.utnfc.argprog.grupo4.data.entities.IncidenteEntity;
import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
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

    public IncidenteEntity findById(int id) {
        try {

            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("IncidenteEntity.findById")
                    .setParameter("IdIncidente", id);

            return (IncidenteEntity) query.getSingleResult();


        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }
    }
}
    
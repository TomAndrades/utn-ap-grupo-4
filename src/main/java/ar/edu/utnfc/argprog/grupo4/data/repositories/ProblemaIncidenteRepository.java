package ar.edu.utnfc.argprog.grupo4.data.repositories;

import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
import ar.edu.utnfc.argprog.grupo4.data.entities.ProblemaIncidenteEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

public class ProblemaIncidenteRepository extends Repository<ProblemaIncidenteEntity,Integer> {
    public ProblemaIncidenteEntity findByIdIncidente(int id) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("ProblemaIncidenteEntity.findById")
                    .setParameter("idIncidente", id);

            return (ProblemaIncidenteEntity) query.getSingleResult();

        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }catch (NoResultException ex){
            System.out.println("Sin datos");
            return null;
        }
    }
}

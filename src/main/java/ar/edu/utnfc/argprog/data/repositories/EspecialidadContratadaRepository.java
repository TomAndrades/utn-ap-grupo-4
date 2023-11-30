package ar.edu.utnfc.argprog.data.repositories;


import ar.edu.utnfc.argprog.entities.EspecialidadContratadaEntity;
import ar.edu.utnfc.argprog.sakila.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.sakila.data.commons.Repository;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;

public class EspecialidadContratadaRepository extends Repository<EspecialidadContratadaEntity, Integer> {

    public List<EspecialidadContratadaEntity> findByClienteCUIT(int CUIT) {
        try {
//            String className = getEntityClass().getSimpleName();
//            ClienteEntity query = entityManager.createNamedQuery("ClienteEntity.findByCUIT")
//                    .setParameter("cuit", CUIT);
//        
//            query.getIdCliente();

            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("EspecialidadContratadaEntity.findbyClienteCUIT")
                    .setParameter("cuit", CUIT);

            return query.getResultList();
            
           
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }
    }
    
    public List<EspecialidadContratadaEntity> findByClienteRazonSocial(int razonSocial) {
        try {

            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("EspecialidadContratadaEntity.findbyClienteRazonSocial")
                    .setParameter("razonSocial", razonSocial);

            return query.getResultList();
            
           
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }
    }

}

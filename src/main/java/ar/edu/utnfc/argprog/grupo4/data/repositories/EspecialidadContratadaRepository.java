package ar.edu.utnfc.argprog.grupo4.data.repositories;


import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadContratadaEntity;
import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;

public class EspecialidadContratadaRepository extends Repository<EspecialidadContratadaEntity, Integer> {

    public List<EspecialidadContratadaEntity> findClienteByCuit(String cuit) {
        try {
//            String className = getEntityClass().getSimpleName();
//            ClienteEntity query = entityManager.createNamedQuery("ClienteEntity.findByCUIT")
//                    .setParameter("cuit", CUIT);
//        
//            query.getIdCliente();

            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("EspecialidadContratadaEntity.findClienteByCuit")
                    .setParameter("cuit", cuit);

            return query.getResultList();
            
           
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }
    }
    
    public List<EspecialidadContratadaEntity> findClienteByRazonSocial(String razonSocial) {
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

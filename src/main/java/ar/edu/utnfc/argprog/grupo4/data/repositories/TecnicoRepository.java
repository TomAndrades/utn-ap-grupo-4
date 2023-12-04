package ar.edu.utnfc.argprog.grupo4.data.repositories;


import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.grupo4.data.entities.ClienteEntity;
import ar.edu.utnfc.argprog.grupo4.data.entities.TecnicoEntity;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.time.LocalDate;
import org.hibernate.HibernateException;

import java.util.List;


public class TecnicoRepository extends Repository<TecnicoEntity, Integer> {

    public TecnicoEntity findById(int id) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("TecnicoEntity.findById")
                    .setParameter("idTecnico", id);

            return (TecnicoEntity) query.getSingleResult();

        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }catch (NoResultException ex){
            System.out.println("No hay tecnicos para esa especialidad");
            return null;
        }
    }
    

    public List<TecnicoEntity> listMasIncidentesResueltos(int dias) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createQuery("SELECT COUNT(i) " +
                                                      "FROM IncidenteEntity i " +
                                                          "JOIN TecnicoEntity t ON i.idTecnico = t.idTecnico " +
                                                     "WHERE i.fechaSolucion BETWEEN " + LocalDate.now().minusDays(dias) + " AND " + LocalDate.now());

            return query.getResultList();
            
 
        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }

    }

}


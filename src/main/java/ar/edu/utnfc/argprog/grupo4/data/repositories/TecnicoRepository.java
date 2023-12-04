package ar.edu.utnfc.argprog.grupo4.data.repositories;


import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.grupo4.data.entities.ClienteEntity;
import ar.edu.utnfc.argprog.grupo4.data.entities.TecnicoEntity;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;


public class TecnicoRepository extends Repository<TecnicoEntity, Integer> {

    public TecnicoEntity findById(int id) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("TecnicoEntity.findById")
                    .setParameter("id_tecnico", id);

            return (TecnicoEntity) query.getSingleResult();

        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }catch (NoResultException ex){
            System.out.println("No Hay tecnicos para esa especialidad");
            return null;
        }
    }

}


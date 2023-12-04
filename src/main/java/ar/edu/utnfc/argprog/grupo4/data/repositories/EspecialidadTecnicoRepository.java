package ar.edu.utnfc.argprog.grupo4.data.repositories;


import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadTecnicoEntity;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;

public class EspecialidadTecnicoRepository extends Repository<EspecialidadTecnicoEntity, Integer> {

    public List<EspecialidadTecnicoEntity> findByEspecialidad(int idEspecialidad) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("EspecialidadTecnicoEntity.findByIdTecnico")
                    .setParameter("id_Especialidad", idEspecialidad);

            return query.getResultList();

        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }

    }
    
  
}


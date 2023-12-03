/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.grupo4.data.repositories;

import ar.edu.utnfc.argprog.grupo4.commons.exceptions.TechnicalException;
import ar.edu.utnfc.argprog.grupo4.data.commons.Repository;
import ar.edu.utnfc.argprog.grupo4.data.entities.ClienteEntity;
import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadContratadaEntity;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.List;

/**
 *
 * @author Loa
 * @author Tomás
 */
public class ClienteRepository extends Repository<ClienteEntity, Integer> {
    public Object findByCuit(String cuit) {
        try {
            String className = getEntityClass().getSimpleName();
            Query query = entityManager.createNamedQuery("ClienteEntity.findByCUIT")
                    .setParameter("cuit", cuit);

            return query.getSingleResult();


        }
        catch (HibernateException ex) {
            throw new TechnicalException(ex);
        }
    }

}

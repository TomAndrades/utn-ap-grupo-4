/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.grupo4.data.commons;

import ar.edu.utnfc.argprog.grupo4.commons.config.Configuracion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocalEntityManagerProvider
{
    private static LocalEntityManagerProvider emProv;
    
    private EntityManager em;
    
    private LocalEntityManagerProvider()
    {
        String persistenceUnitName = Configuracion.getInstancia().getValue("persistenceUnitName");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        
        em = emf.createEntityManager();
    }
    
    public static EntityManager getEntityManager()// Creo un patron singleton por el echo de que el entity manager demora demaciado en crearse; Esto me lleva amantener el entity manager creado y cerrarlo al finalizar la aplicacion
    {
        if (emProv == null)
            emProv = new LocalEntityManagerProvider();
        
        return emProv.em;
    }
    
    public static void closeEntityManager()
    {
        if (emProv.em != null)
        {
            emProv.em.close();
            emProv = null;
        }
    }
    
}


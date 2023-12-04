package ar.edu.utnfc.argprog.grupo4.operacion;

import ar.edu.utnfc.argprog.grupo4.data.commons.LocalEntityManagerProvider;
import ar.edu.utnfc.argprog.grupo4.data.entities.IncidenteEntity;
import ar.edu.utnfc.argprog.grupo4.data.entities.ProblemaIncidenteEntity;
import ar.edu.utnfc.argprog.grupo4.data.repositories.IncidenteRepository;
import ar.edu.utnfc.argprog.grupo4.data.repositories.ProblemaIncidenteRepository;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class Modificar implements Runnable{
    @Override
    public void run() {
        Scanner sc= new Scanner(System.in);
        EntityManager em = LocalEntityManagerProvider.getEntityManager();
        System.out.println("Ingrese el Id del incidente: ");
        int id=sc.nextInt();
        ProblemaIncidenteEntity pin = new ProblemaIncidenteRepository().findByIdIncidente(id);
        IncidenteEntity in = new IncidenteRepository().findById(id);
        em.detach(pin);
        pin.setResuelto(1);
        pin=em.merge(pin);
        em.getTransaction().begin();
        em.persist(pin);
        em.getTransaction().commit();
        em.detach(in);
        in.setResuelto();
        em.getTransaction().begin();
        em.persist(in);
        em.getTransaction().commit();
        System.out.println("Estado cambiado a resuelto");
    }
}

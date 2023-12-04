package ar.edu.utnfc.argprog.grupo4.operacion;

import ar.edu.utnfc.argprog.grupo4.data.commons.LocalEntityManagerProvider;
import ar.edu.utnfc.argprog.grupo4.data.entities.*;
import ar.edu.utnfc.argprog.grupo4.data.repositories.ClienteRepository;
import ar.edu.utnfc.argprog.grupo4.data.repositories.EspecialidadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agregar implements Runnable {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String rz,mail,cel,des,cuit;
        int n;
        List<String> espCon = new ArrayList<>();
        List<EspecialidadEntity> listEs= new EspecialidadRepository()
                .findAll();
        EntityManager em = LocalEntityManagerProvider.getEntityManager();

        ClienteEntity cl = new ClienteEntity();

        System.out.print("Ingrese CUIT del Cliente: ");
        cuit=sc.nextLine();
        cl= new ClienteRepository().findByCuit(cuit);
        if(cl==null) {
            EspecialidadContratadaEntity ec = new EspecialidadContratadaEntity();
            IncidenteEntity in = new IncidenteEntity();
            ProblemaIncidenteEntity pi = new ProblemaIncidenteEntity();
            System.out.print("Ingrese Razon Social: ");
            rz = sc.nextLine();
            System.out.print("Ingrese E-mail: ");
            mail = sc.nextLine();
            System.out.print("Ingrese celular: ");
            cel = sc.nextLine();

            cl.setRazonSocial(rz);
            cl.setCel(cel);
            cl.setCuit(cuit);
            cl.setMail(mail);
            em.getTransaction().begin();
            em.persist(cl);
            em.getTransaction().commit();// Subo el cliente a la BD

            cl= new ClienteRepository().findByCuit(cuit);// pido el cliente para obtener el ID

            System.out.print("Ingrese la cantidad de especialidades que tiene contratadas el cliente");
            n=sc.nextInt();
            for(int i=0;i<n;i++){
                System.out.print("Ingrese especialidad:");
                espCon.add(sc.nextLine());
            }

            while(n>0){
                ec.setClienteEntity(cl);
                
                n--;
            }
        }




    }
}

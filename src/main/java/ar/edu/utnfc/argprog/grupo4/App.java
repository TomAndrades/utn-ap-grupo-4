package ar.edu.utnfc.argprog.grupo4;

import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadContratadaEntity;
import ar.edu.utnfc.argprog.grupo4.data.repositories.ClienteRepository;
import ar.edu.utnfc.argprog.grupo4.data.repositories.EspecialidadContratadaRepository;
import ar.edu.utnfc.argprog.grupo4.operacion.Agregar;
import ar.edu.utnfc.argprog.grupo4.operacion.Listar;
import ar.edu.utnfc.argprog.grupo4.operacion.Modificar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;


public class App 
{

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UTNAppGrupo4-PU");

        EntityManager em = emf.createEntityManager();

        Runnable operacion[]={
                ()-> new Agregar().run(),
                ()-> new Modificar().run(),
                ()-> new Listar().run(),
        };
        int a;
        System.out.println("Bienvenido al sistema de Incidentes ");

        Scanner leer = new Scanner(System.in);

        do{
            System.out.println("Ingrese un la opcion requerida:");
            System.out.println("1: Agregar Incidente");
            System.out.println("2: Modificar estado de incidente");
            System.out.println("3: Listar Incidentes");
            System.out.println("0: Salir");
            System.out.print("Ingrese su opcion: ");
            a=leer.nextInt();
            if(a<0 || a>3){
                System.out.println("Opcion incorrecta...\nVuelva a ingresar....");
            }else{
                if(a!=0){
                    operacion[a-1].run();
                }
            }
        }while(a!=0);

        List<EspecialidadContratadaEntity> especialidad1 = new EspecialidadContratadaRepository().findClienteByCuit("20419140857");
        System.out.println(especialidad1);


        em.close();

    }
}

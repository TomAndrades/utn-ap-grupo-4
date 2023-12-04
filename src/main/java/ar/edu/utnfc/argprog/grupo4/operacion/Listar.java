package ar.edu.utnfc.argprog.grupo4.operacion;

import ar.edu.utnfc.argprog.grupo4.data.entities.TecnicoEntity;
import ar.edu.utnfc.argprog.grupo4.data.repositories.TecnicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listar implements Runnable {

    Scanner sc = new Scanner(System.in);
    @Override
    public void run() {
        Runnable operacion[]={
                ()-> {
                    System.out.print("Ingrese la candidad de dias: ");
                    int n=sc.nextInt();
                    List<TecnicoEntity> tecnico = new TecnicoRepository().listMasIncidentesResueltos(n);
                    tecnico.forEach(System.out::println);
                },
                ()-> new Modificar().run(),
                ()-> new Listar().run(),
        };
        int a;

        Scanner leer = new Scanner(System.in);

        do{
            System.out.println("Ingrese un la opcion requerida:");
            System.out.println("1: Tecnico con mas incidentes resueltos");
//            System.out.println("2: Modificar estado de incidente");
//            System.out.println("3: Listar Incidentes");
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
    }
}

package ar.edu.utnfc.argprog.grupo4.operacion;

import ar.edu.utnfc.argprog.grupo4.data.commons.LocalEntityManagerProvider;
import ar.edu.utnfc.argprog.grupo4.data.entities.*;
import ar.edu.utnfc.argprog.grupo4.data.repositories.*;

import jakarta.persistence.EntityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Agregar implements Runnable {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String rz,mail,cel,des,cuit;
        int n,i;
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

            cl= new ClienteRepository().findByCuit(cuit);// Pido el cliente para obtener el ID

            System.out.print("Ingrese la cantidad de especialidades que tiene contratadas el cliente");
            n=sc.nextInt();
            for(i=0;i<n;i++){
                System.out.print("Ingrese especialidad:");
                espCon.add(sc.nextLine());
            }
            ec.setClienteEntity(cl);
            i=0;
            for(String s : espCon){
                while(i<listEs.size()) {// No se me ocurrio otra forma de hacerlo pero si se puede cambiar mejor
                    if(s.equals(listEs.get(i).getNombre())) {
                        ec.setEspecialidadEntity(listEs.get(i));
                        em.getTransaction().begin();
                        em.persist(ec);
                        em.getTransaction().commit();
                    }
                    i++;
                }
            }
        }else{
            System.out.println("El cliente ya se encuentra en la BD");
        }
        List<EspecialidadContratadaEntity> listContratado = new EspecialidadContratadaRepository().findClienteByCuit(cuit);// pido las Especialidades del cliente
        String problema;

        System.out.print("Por que especialidad es el problema: ");
        problema=sc.nextLine();
        EspecialidadEntity ct = null;
        listContratado.forEach(f->{

        });

        for (EspecialidadContratadaEntity x: listContratado) {
            if(problema.equals(x.getEspecialidadEntity().getNombre())){     //Obtengo la especialidad
                ct = x.getEspecialidadEntity();
            }
        }
        System.out.println("Ingrese una descripcion del incidente:");
        des=sc.nextLine();


        EspecialidadTecnicoEntity Esptecnicos = new EspecialidadTecnicoRepository().findByEspecialidad(ct.getIdEspecialidad());// Esta mal....Esta devolviendo un solo tecnico
        List<TecnicoEntity> Tecnicos = new TecnicoRepository().findById(Esptecnicos.getIdEspecialidadTecnico());
        System.out.println("Elija un tecnico para asignar: ");
        Tecnicos.forEach(System.out::println);
        int idTecnico;
        System.out.print("Ingrese el id del Tecnico: ");
        idTecnico = sc.nextInt();
        Date ingreso,egreso;
        try {
            System.out.print("Ingrese la fecha de ingreso(DD/MM/AAAA): ");
            String fecha;
            fecha=sc.nextLine();
            SimpleDateFormat parsear= new SimpleDateFormat("DD/MM/AAAA");
            ingreso=parsear.parse(fecha);
            System.out.print("Ingrese la fecha de egreso estimada(DD/MM/AAAA): ");
            fecha=sc.nextLine();
            egreso=parsear.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        IncidenteEntity in = new IncidenteEntity();
        ProblemaIncidenteEntity pi = new ProblemaIncidenteEntity();

        TecnicoEntity tecnico = new TecnicoRepository().findById(idTecnico);     // Esta devolviendo una lista Por eso el error
        in.setClienteEntity(cl);
        in.setDescripcion(des);
        in.setEspecialidadEntity(ct);
        in.setTecnicoEntity(tecnico);
        em.getTransaction().begin();
        em.persist(in);
        em.getTransaction().commit();

        pi.setDescripcion(des);
        pi.setResuelto(0);
        pi.setIncidenteEntity(in);
        String tipo;
        System.out.print("Ingrese el Tipo de Problema: ");
        tipo=sc.nextLine();
        pi.setTipo(tipo);

        em.getTransaction().begin();
        em.persist(pi);
        em.getTransaction().commit();

    }
}

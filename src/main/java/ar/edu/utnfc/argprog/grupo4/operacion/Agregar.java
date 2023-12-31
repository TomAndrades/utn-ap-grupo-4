package ar.edu.utnfc.argprog.grupo4.operacion;

import ar.edu.utnfc.argprog.grupo4.data.commons.LocalEntityManagerProvider;
import ar.edu.utnfc.argprog.grupo4.data.entities.*;
import ar.edu.utnfc.argprog.grupo4.data.repositories.*;

import jakarta.persistence.EntityManager;

import java.nio.Buffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

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
        try {
            System.out.print("Ingrese CUIT del Cliente: ");
            cuit=sc.nextLine();
            ClienteEntity cl= new ClienteRepository().findByCuit(cuit);
            if(cl==null) {
                cl = new ClienteEntity();


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

                System.out.print("Ingrese la cantidad de especialidades que tiene contratadas el cliente: ");
                n = sc.nextInt();
                sc.nextLine();
                for(i=0;i<n;i++){
                    System.out.print("Ingrese especialidad: ");
                    espCon.add(sc.nextLine());
                }


                for(String s : espCon){
                    i=0;
                    while(i<listEs.size()) {// No se me ocurrio otra forma de hacerlo pero si se puede cambiar mejor
                        if(s.trim().equals(listEs.get(i).getNombre())) {
                            EspecialidadContratadaEntity ec = new EspecialidadContratadaEntity();
                            ec.setClienteEntity(cl);
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
            EspecialidadEntity ct =new EspecialidadEntity();

            for (EspecialidadContratadaEntity x: listContratado) {
                if(problema.trim().equals(x.getEspecialidadEntity().getNombre())){     //Obtengo la especialidad
                    ct = x.getEspecialidadEntity();
                    break;
                }
            }
            System.out.println("Ingrese una descripcion del incidente:");
            des=sc.nextLine();


            List<EspecialidadTecnicoEntity> Esptecnicos = new EspecialidadTecnicoRepository().findByEspecialidad(ct.getIdEspecialidad());
            List<TecnicoEntity> Tecnicos = new ArrayList<>();

            for (EspecialidadTecnicoEntity x : Esptecnicos) {
                Tecnicos.add(new TecnicoRepository().findById(x.getTecnicoEntity().getIdTecnico()));
            }
            System.out.println("Elija un tecnico para asignar: ");
            Tecnicos.forEach(System.out::println);
            int idTecnico;
            System.out.print("Ingrese el id del Tecnico: ");
            idTecnico = sc.nextInt();
            sc.nextLine();
            Date ingreso,egreso;

                System.out.print("Ingrese la fecha de ingreso(DD/MM/AAAA): ");
                String fecha;
                fecha=sc.nextLine();
                SimpleDateFormat parsear= new SimpleDateFormat("dd/MM/yyyy");
                ingreso=parsear.parse(fecha);
                System.out.print("Ingrese la fecha de egreso estimada(DD/MM/YYYY): ");
                fecha=sc.nextLine();
                egreso=parsear.parse(fecha);

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
        } catch (NullPointerException ex){
            System.out.println("Tablas vacias");
            throw new NullPointerException();
        } catch (ParseException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}

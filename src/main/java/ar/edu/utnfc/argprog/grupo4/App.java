package ar.edu.utnfc.argprog.grupo4;

import ar.edu.utnfc.argprog.grupo4.data.commons.LocalEntityManagerProvider;
import ar.edu.utnfc.argprog.grupo4.data.entities.ClienteEntity;
import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadContratadaEntity;
import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadEntity;
import ar.edu.utnfc.argprog.grupo4.data.repositories.ClienteRepository;
import ar.edu.utnfc.argprog.grupo4.data.repositories.EspecialidadContratadaRepository;
import ar.edu.utnfc.argprog.grupo4.data.repositories.EspecialidadRepository;

import java.util.List;

public class App 
{

    public static void main(String[] args)
    {
//        ClienteRepository clienteRepository = new ClienteRepository();
//        System.out.println("\n\nInicio de las pruebas ==>");
////
//        List<EspecialidadContratadaEntity> listaEspecialidadContratada = new EspecialidadContratadaRepository().findClienteByCuit("12345678901");
//        System.out.println("Lista de lenguajes antes del insert");
//        listaEspecialidadContratada.stream()
//                .forEach(l -> System.out.println(l));
////        IncidenteEntity incidenteDePrueba = new IncidenteEntity("Este es un incidente de prueba");
//        ClienteEntity cliente1 = new ClienteEntity("Tomas Andrades", "20419140857", "andradestom@gmail.com", "+5491162368476");
//        clienteRepository.create(cliente1);
//        clienteRepository.
//        LocalEntityManagerProvider.closeEntityManager();
        Object getCliente =  new ClienteRepository().findByCuit("20419140857");
        List<EspecialidadContratadaEntity> especialidad1 = new EspecialidadContratadaRepository().findClienteByCuit("20419140857");
        System.out.println(especialidad1);

    }
}

package ar.edu.utnfc.argprog.grupo4;

import ar.edu.utnfc.argprog.grupo4.data.commons.LocalEntityManagerProvider;
import ar.edu.utnfc.argprog.grupo4.data.entities.EspecialidadEntity;
import ar.edu.utnfc.argprog.grupo4.data.repositories.EspecialidadContratadaRepository;
import ar.edu.utnfc.argprog.grupo4.data.repositories.EspecialidadRepository;

import java.sql.SQLOutput;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("\n\nInicio de las pruebas ==>");

        List<EspecialidadEntity> listaEspecialidad = new EspecialidadRepository()
                .findAll();
        System.out.println(listaEspecialidad);
        listaEspecialidad.stream().forEach(l -> System.out.println(l));

        LocalEntityManagerProvider.closeEntityManager();
    }
}

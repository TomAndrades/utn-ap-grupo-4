package ar.edu.utnfc.argprog.commons.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public final class Configuracion implements Iterable<String> {

    private static final String PROP_FILE_NAME = "application.properties";

    // Miembros de Clase ==> para el Singletón
    // Atributo del Singleton
    private static Configuracion instancia = null;
//
//    // Método de
    public static Configuracion getInstancia() {

        if (instancia == null) {

            instancia = new Configuracion();
        }
        return instancia;
    }

    // Miembros de instancia
    // Atributos de la instancia
    private Properties p;

    // Constructor de la instancia
    private Configuracion() {
        try (InputStream inStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME)) {
            p = new Properties();
            p.load(inStream);

        }
        catch (IOException e) {
            System.err.println("Fatal: no existe el archivo de configuración");
            e.printStackTrace();
            System.exit(-1);
        }

    }

    private Configuracion(String propFile) {

    }

    public String getValue(String clave) {

        return p.getProperty(clave);
    }

    public void setValue(String clave, String valor) {

        p.setProperty(clave, valor);
    }

    public Iterator<String> iterator() {
        return p.stringPropertyNames().iterator();
    }


}
package ar.edu.utnfc.argprog.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Incidente {
    private Integer id;
    private String tipo;
    private String descripcion;
    private Estado estado;
    private LocalDate fechaDeCreacion;
    private LocalDate finalizacionEstimada; // SOLO SI ES COMPLEJO
    private LocalDate fechaDeFinalizacion;
    private Operador operador;
    private List<String> reportes;

}

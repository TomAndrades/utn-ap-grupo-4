/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.grupo4.data.entities;

import ar.edu.utnfc.argprog.grupo4.data.commons.DalEntity;
import ar.edu.utnfc.argprog.grupo4.data.repositories.ClienteRepository;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "incidentes")
@NamedQueries(
{
    @NamedQuery(name = "IncidenteEntity.findAll", query = "SELECT i FROM IncidenteEntity i"),
    @NamedQuery(name = "IncidenteEntity.findByTecnico",query = "SELECT i FROM IncidenteEntity i WHERE i.tecnicoEntity.idTecnico = :idTecnico"),
    @NamedQuery (name = "IncidenteEntity.findByID", query= "SELECT i FROM IncidenteEntity i WHERE i.idIncidente = :idIncidente ")
})
public class IncidenteEntity implements DalEntity,Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncidente")
    private Short idIncidente;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne
    private ClienteEntity clienteEntity;
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "idEspecialidad")
    @ManyToOne
    private EspecialidadEntity especialidadEntity;
    @JoinColumn(name = "idTecnico", referencedColumnName = "idTecnico")
    @ManyToOne
    private TecnicoEntity tecnicoEntity;
    @Basic(optional = false)
    @Column(name = "resuelto")
    private boolean resuelto;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fechaSolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    @Column(name = "descripcion")
    private String descripcion;
    

    public IncidenteEntity()
    {
    }

    public IncidenteEntity(String descripcion) {
        this.resuelto = false;
        this.fechaCreacion = getDateNow();
        this.descripcion = descripcion;
    }

    public Short getIdIncidente() {
        return idIncidente;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public EspecialidadEntity getEspecialidadEntity() {
        return especialidadEntity;
    }

    public void setEspecialidadEntity(EspecialidadEntity especialidadEntity) {
        this.especialidadEntity = especialidadEntity;
    }

    public TecnicoEntity getTecnicoEntity() {
        return tecnicoEntity;
    }

    public void setTecnicoEntity(TecnicoEntity tecnicoEntity) {
        this.tecnicoEntity = tecnicoEntity;
    }

    public boolean getResuelto() {
        return resuelto;
    }

    public void setResuelto() {
        this.resuelto = true;
        this.fechaSolucion = getDateNow();
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public Date getFechaSolucion() {
        return fechaSolucion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDateNow(){
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idIncidente != null ? idIncidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidenteEntity))
        {
            return false;
        }
        IncidenteEntity other = (IncidenteEntity) object;
        if ((this.idIncidente == null && other.idIncidente != null) || (this.idIncidente != null && !this.idIncidente.equals(other.idIncidente)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.IncidenteEntity[ idIncidente=" + idIncidente + " ]";
    }
    
}


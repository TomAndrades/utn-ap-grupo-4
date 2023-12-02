/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.grupo4.data.entities;

import ar.edu.utnfc.argprog.grupo4.data.commons.DalEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "incidente")
@NamedQueries(
{
    @NamedQuery(name = "IncidenteEntity.findAll", query = "SELECT i FROM IncidenteEntity i"),
    @NamedQuery(name = "IncidenteEntity.findByTecnico",query = "SELECT i FROM IncidenteEntity i WHERE i.tecnicoEntity.idTecnico = :idTecnico")
    
})
public class IncidenteEntity implements DalEntity,Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_incidente")
    private Short idIncidente;
    @JoinColumn(name = "idCliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private ClienteEntity clienteEntity;
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private EspecialidadEntity especialidadEntity;
    @JoinColumn(name = "idTecnico", referencedColumnName = "id_tecnico")
    @ManyToOne
    private TecnicoEntity tecnicoEntity;
    @Basic(optional = false)
    @Column(name = "resuelto")
    private String resuelto;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fechaSolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    

    public IncidenteEntity()
    {
    }

    public IncidenteEntity(Short idIncidente)
    {
        this.idIncidente = idIncidente;
    }

    public IncidenteEntity(Short idIncidente, ClienteEntity clienteEntity, EspecialidadEntity especialidadEntity, TecnicoEntity tecnicoEntity, String resuelto, Date fechaCreacion, Date fechaSolucion) {
        this.idIncidente = idIncidente;
        this.clienteEntity = clienteEntity;
        this.especialidadEntity = especialidadEntity;
        this.tecnicoEntity = tecnicoEntity;
        this.resuelto = resuelto;
        this.fechaCreacion = fechaCreacion;
        this.fechaSolucion = fechaSolucion;
    }

    public Short getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Short idIncidente) {
        this.idIncidente = idIncidente;
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

    public String getResuelto() {
        return resuelto;
    }

    public void setResuelto(String resuelto) {
        this.resuelto = resuelto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
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


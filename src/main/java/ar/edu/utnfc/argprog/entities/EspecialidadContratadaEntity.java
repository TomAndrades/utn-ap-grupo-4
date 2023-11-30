/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.entities;

import ar.edu.utnfc.argprog.data.commons.DalEntity;
import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "especialidadcontratada")
@NamedQueries(
{
    @NamedQuery(name = "EspecialidadContratadaEntity.findAll", query = "SELECT e FROM EspecialidadContratadaEntity e"),
    @NamedQuery(name = "EspecialidadContratadaEntity.findbyClienteCUIT", query = "SELECT e FROM EspecialidadContradaEntity e WHERE e.clienteEntity.cuit = :cuit"),
    @NamedQuery(name = "EspecialidadContratadaEntity.findbyClienteRazonSocial", query = "SELECT e FROM EspecialidadContradaEntity e WHERE e.clienteEntity.razonSocial = :razonSocial")
})
public class EspecialidadContratadaEntity extends DalEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEspecialidadContratada")
    private Short idEspecialidadContratada;
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "idEspecialidad")
    @ManyToOne
    private EspecialidadEntity especialidadEntity;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne
    private ClienteEntity clienteEntity;


    public EspecialidadContratadaEntity()
    {
    }

    public EspecialidadContratadaEntity(Short idEspecialidadContratada)
    {
        this.idEspecialidadContratada = idEspecialidadContratada;
    }

    public EspecialidadContratadaEntity(Short idEspecialidadContratada, EspecialidadEntity especialidadEntity, ClienteEntity clienteEntity) {
        this.idEspecialidadContratada = idEspecialidadContratada;
        this.especialidadEntity = especialidadEntity;
        this.clienteEntity = clienteEntity;
    }

    public Short getIdEspecialidadContratada() {
        return idEspecialidadContratada;
    }

    public void setIdEspecialidadContratada(Short idEspecialidadContratada) {
        this.idEspecialidadContratada = idEspecialidadContratada;
    }

    public EspecialidadEntity getEspecialidadEntity() {
        return especialidadEntity;
    }

    public void setEspecialidadEntity(EspecialidadEntity especialidadEntity) {
        this.especialidadEntity = especialidadEntity;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idEspecialidadContratada != null ? idEspecialidadContratada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadContratadaEntity))
        {
            return false;
        }
        EspecialidadContratadaEntity other = (EspecialidadContratadaEntity) object;
        if ((this.idEspecialidadContratada == null && other.idEspecialidadContratada != null) || (this.idEspecialidadContratada != null && !this.idEspecialidadContratada.equals(other.idEspecialidadContratada)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.EspecialidadContratadaEntity[ idEspecialidadContratada= " + idEspecialidadContratada + " ]";
    }
    
}



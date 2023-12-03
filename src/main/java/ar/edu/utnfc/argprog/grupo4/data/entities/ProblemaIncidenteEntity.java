/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.grupo4.data.entities;

import ar.edu.utnfc.argprog.grupo4.data.commons.DalEntity;
import java.io.Serializable;

import jakarta.persistence.*;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "problemas_incidentes")
@NamedQueries(
{
    @NamedQuery(name = "ProblemaIncidenteEntity.findAll", query = "SELECT p FROM ProblemaIncidenteEntity p"),
    
})
public class ProblemaIncidenteEntity implements DalEntity,Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProblemaIncidente")
    private Short idProblemaIncidente;
    @JoinColumn(name = "idIncidente", referencedColumnName = "idIncidente")
    @ManyToOne
    private IncidenteEntity incidenteEntity;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "resuelto")
    private int resuelto;


    public ProblemaIncidenteEntity()
    {
    }

    public ProblemaIncidenteEntity(Short idProblemaIncidente)
    {
        this.idProblemaIncidente = idProblemaIncidente;
    }

    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idProblemaIncidente != null ? idProblemaIncidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProblemaIncidenteEntity))
        {
            return false;
        }
        ProblemaIncidenteEntity other = (ProblemaIncidenteEntity) object;
        if ((this.idProblemaIncidente  == null && other.idProblemaIncidente != null) || (this.idProblemaIncidente  != null && !this.idProblemaIncidente .equals(other.idProblemaIncidente )))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.ProblemaIncidenteEntity[ idProblemaIncidente =" +idProblemaIncidente  + " ]";
    }
    
}



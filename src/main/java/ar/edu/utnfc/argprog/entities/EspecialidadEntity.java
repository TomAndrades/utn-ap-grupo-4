/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.entities;

import ar.edu.utnfc.argprog.data.commons.DalEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "especialidad")
@NamedQueries(
{
    @NamedQuery(name = "EspecialidadEntity.findAll", query = "SELECT e FROM EspecialidadEntity e"),
    
})
public class EspecialidadEntity extends DalEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEspecialidad")
    private Short idEspecialidad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "especialidadCol")
    private String especialidadCol;


    public EspecialidadEntity()
    {
    }

    public EspecialidadEntity(Short idEspecialidad)
    {
        this.idEspecialidad = idEspecialidad;
    }

    
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadEntity))
        {
            return false;
        }
        EspecialidadEntity other = (EspecialidadEntity) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.EspecialidadEntity[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}


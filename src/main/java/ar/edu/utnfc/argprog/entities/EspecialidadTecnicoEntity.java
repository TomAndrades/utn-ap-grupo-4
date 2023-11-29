/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.entities;

import ar.edu.utnfc.argprog.data.commons.DalEntity;
import java.io.Serializable;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "especialidadtecnico")
@NamedQueries(
{
    @NamedQuery(name = "EspecialidadTecnicoEntity.findAll", query = "SELECT e FROM EspecialidadTecnicoEntity e"),
    
})
public class EspecialidadTecnicoEntity implements DalEntity, Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEspecialidadTecnico")
    private Short idEspecialidadTecnico;
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "idEspecialidad")
    @ManyToOne
    private EspecialidadEntity especialidadEntity;
    @JoinColumn(name = "idTecnico", referencedColumnName = "idTecnico")
    @ManyToOne
    private TecnicoEntity tecnicoEntity;

    

    public EspecialidadTecnicoEntity()
    {
    }

    public EspecialidadTecnicoEntity(Short idEspecialidadTecnico)
    {
        this.idEspecialidadTecnico = idEspecialidadTecnico;
    }

    public EspecialidadTecnicoEntity(Short idEspecialidadTecnico, EspecialidadEntity especialidadEntity, TecnicoEntity tecnicoEntity) {
        this.idEspecialidadTecnico = idEspecialidadTecnico;
        this.especialidadEntity = especialidadEntity;
        this.tecnicoEntity = tecnicoEntity;
    }

    public Short getIdEspecialidadTecnico() {
        return idEspecialidadTecnico;
    }

    public void setIdEspecialidadTecnico(Short idEspecialidadTecnico) {
        this.idEspecialidadTecnico = idEspecialidadTecnico;
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


    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idEspecialidadTecnico != null ? idEspecialidadTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadTecnicoEntity))
        {
            return false;
        }
        EspecialidadTecnicoEntity other = (EspecialidadTecnicoEntity) object;
        if ((this.idEspecialidadTecnico == null && other.idEspecialidadTecnico != null) || (this.idEspecialidadTecnico != null && !this.idEspecialidadTecnico.equals(other.idEspecialidadTecnico)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.EspecialidadTecnicoEntity[ idEspecialidadTecnico= " + idEspecialidadTecnico + " ]";
    }
    
}




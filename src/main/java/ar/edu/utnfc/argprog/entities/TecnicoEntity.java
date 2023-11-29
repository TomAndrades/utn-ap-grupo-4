/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.entities;


import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "tecnico")
@NamedQueries(
{
    @NamedQuery(name = "TecnicoEntity.findAll", query = "SELECT t FROM TecnicoEntity t"),
    @NamedQuery(name = "TecnicoEntity.findTecnicoById", query = "SELECT t FROM TecnicoEntity t WHERE t.idTecnico = :idTecnico"),
    @NamedQuery(name = "TecnicoEntity.findByLegajo", query = "SELECT t FROM TecnicoEntity t WHERE t.legajo = :legajo"),
    @NamedQuery(name = "TecnicoEntity.findByName", query = "SELECT t FROM TecnicoEntity t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TecnicoEntity.findByDni", query = "SELECT t FROM TecnicoEntity t WHERE t.dni = :dni")
})
public class TecnicoEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTecnico")
    private Short idTecnico;
    @Basic(optional = false)
    @Column(name = "legajo")
    private int legajo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "dni")
    private int dni;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "cel")
    private String cel;
//    @Basic(optional = false)
//    @Column(name = "last_update")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "TecnicoEntity")
//    private Collection<FilmActorEntity> filmActorEntityCollection;

    public TecnicoEntity()
    {
    }

    public TecnicoEntity(Short actorId)
    {
        this.idTecnico = idTecnico;
    }

    public TecnicoEntity(Short idTecnico, int legajo, String nombre, int dni, String mail, String cel) {
        this.idTecnico = idTecnico;
        this.legajo = legajo;
        this.nombre = nombre;
        this.dni = dni;
        this.mail = mail;
        this.cel = cel;
    }

    public Short getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Short idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    
    
   
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idTecnico != null ? idTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnicoEntity))
        {
            return false;
        }
        TecnicoEntity other = (TecnicoEntity) object;
        if ((this.idTecnico == null && other.idTecnico != null) || (this.idTecnico != null && !this.idTecnico.equals(other.idTecnico)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.TecnicoEntity[ idTecnico=" + idTecnico + " ]";
    }
}
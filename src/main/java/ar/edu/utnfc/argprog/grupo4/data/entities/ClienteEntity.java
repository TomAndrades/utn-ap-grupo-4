/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utnfc.argprog.grupo4.data.entities;

import java.io.Serializable;

import ar.edu.utnfc.argprog.grupo4.data.commons.DalEntity;
import jakarta.persistence.*;

/**
 *
 * @author Loa
 */
@Entity
@Table(name = "clientes")
@NamedQueries(
{
    @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT c FROM ClienteEntity c"),
    @NamedQuery(name = "ClienteEntity.findByClienteId", query = "SELECT c FROM ClienteEntity c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "ClienteEntity.findByRazonSocial", query = "SELECT c FROM ClienteEntity  c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "ClienteEntity.findByCUIT", query = "SELECT c FROM ClienteEntity c WHERE c.cuit = :cuit")
})

public class ClienteEntity implements DalEntity, Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Short idCliente;
    @Basic(optional = false)
    @Column(name = "razonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "cuit")
    private String cuit;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @Column(name = "cel")
    private String cel;


    

    public ClienteEntity()
    {
    }

    public ClienteEntity(String razonSocial, String cuit, String mail, String cel) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.mail = mail;
        this.cel = cel;
    }

    public Short getIdCliente() {
        return idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity))
        {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ar.edu.utnfc.argprog.data.entities.ClienteEntity[ customerId=" + idCliente + " ]";
    }
    
}

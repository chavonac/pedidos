/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chavon
 */
@Entity
@Table(name = "periodos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodos.findAll", query = "SELECT p FROM Periodos p"),
    @NamedQuery(name = "Periodos.findByIdPeriodo", query = "SELECT p FROM Periodos p WHERE p.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "Periodos.findByCvePeriodo", query = "SELECT p FROM Periodos p WHERE p.cvePeriodo = :cvePeriodo"),
    @NamedQuery(name = "Periodos.findByNombre", query = "SELECT p FROM Periodos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Periodos.findByFechaInicio", query = "SELECT p FROM Periodos p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Periodos.findByFechaFin", query = "SELECT p FROM Periodos p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Periodos.findByNotas", query = "SELECT p FROM Periodos p WHERE p.notas = :notas")})
public class Periodos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodo")
    private Integer idPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cve_periodo")
    private String cvePeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 255)
    @Column(name = "notas")
    private String notas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodo")
    @JsonIgnore
    private Collection<Pedidos> pedidosCollection;

    public Periodos() {
    }

    public Periodos(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Periodos(Integer idPeriodo, String cvePeriodo, String nombre) {
        this.idPeriodo = idPeriodo;
        this.cvePeriodo = cvePeriodo;
        this.nombre = nombre;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getCvePeriodo() {
        return cvePeriodo;
    }

    public void setCvePeriodo(String cvePeriodo) {
        this.cvePeriodo = cvePeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodos)) {
            return false;
        }
        Periodos other = (Periodos) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.msc.pedidos.entidades.Periodos[ idPeriodo=" + idPeriodo + " ]";
    }
    
}

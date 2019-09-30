/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chavon
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdPago", query = "SELECT p FROM Pagos p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "Pagos.findByAdeudo", query = "SELECT p FROM Pagos p WHERE p.adeudo = :adeudo"),
    @NamedQuery(name = "Pagos.findByAbono", query = "SELECT p FROM Pagos p WHERE p.abono = :abono"),
    @NamedQuery(name = "Pagos.findByInsoluto", query = "SELECT p FROM Pagos p WHERE p.insoluto = :insoluto"),
    @NamedQuery(name = "Pagos.findByFecha", query = "SELECT p FROM Pagos p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pagos.findByNotas", query = "SELECT p FROM Pagos p WHERE p.notas = :notas")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "adeudo")
    private BigDecimal adeudo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono")
    private BigDecimal abono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insoluto")
    private BigDecimal insoluto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "notas")
    private String notas;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedidos idPedido;

    public Pagos() {
    }

    public Pagos(Integer idPago) {
        this.idPago = idPago;
    }

    public Pagos(Integer idPago, BigDecimal adeudo, BigDecimal abono, BigDecimal insoluto, Date fecha) {
        this.idPago = idPago;
        this.adeudo = adeudo;
        this.abono = abono;
        this.insoluto = insoluto;
        this.fecha = fecha;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(BigDecimal adeudo) {
        this.adeudo = adeudo;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public BigDecimal getInsoluto() {
        return insoluto;
    }

    public void setInsoluto(BigDecimal insoluto) {
        this.insoluto = insoluto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.msc.pedidos.entidades.Pagos[ idPago=" + idPago + " ]";
    }
    
}

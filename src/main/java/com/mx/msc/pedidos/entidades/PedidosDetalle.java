/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chavon
 */
@Entity
@Table(name = "pedidos_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosDetalle.findAll", query = "SELECT p FROM PedidosDetalle p"),
    @NamedQuery(name = "PedidosDetalle.findByIdPedidoDetalle", query = "SELECT p FROM PedidosDetalle p WHERE p.idPedidoDetalle = :idPedidoDetalle"),
    @NamedQuery(name = "PedidosDetalle.findByPrecio", query = "SELECT p FROM PedidosDetalle p WHERE p.precio = :precio"),
    @NamedQuery(name = "PedidosDetalle.findByTieneOferta", query = "SELECT p FROM PedidosDetalle p WHERE p.tieneOferta = :tieneOferta")})
public class PedidosDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido_detalle")
    private Integer idPedidoDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tiene_oferta")
    private String tieneOferta;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedidos idPedido;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public PedidosDetalle() {
    }

    public PedidosDetalle(Integer idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public PedidosDetalle(Integer idPedidoDetalle, BigDecimal precio, String tieneOferta) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.precio = precio;
        this.tieneOferta = tieneOferta;
    }

    public Integer getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(Integer idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getTieneOferta() {
        return tieneOferta;
    }

    public void setTieneOferta(String tieneOferta) {
        this.tieneOferta = tieneOferta;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoDetalle != null ? idPedidoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosDetalle)) {
            return false;
        }
        PedidosDetalle other = (PedidosDetalle) object;
        if ((this.idPedidoDetalle == null && other.idPedidoDetalle != null) || (this.idPedidoDetalle != null && !this.idPedidoDetalle.equals(other.idPedidoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mx.msc.pedidos.entidades.PedidosDetalle[ idPedidoDetalle=" + idPedidoDetalle + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.pedidosdetalle;

import java.math.BigDecimal;

/**
 *
 * @author sergiov
 */
public class PedidosDetalleMapping {

    private Integer idPedidoDetalle;
    private Integer idPedido;
    private Integer idProducto;
    private BigDecimal precio;
    private String tieneOferta;
    private String cveProducto;
    private String nombreProducto;
    private BigDecimal cantidad;
    
      public PedidosDetalleMapping() {
    }

    public PedidosDetalleMapping(Integer idPedidoDetalle, Integer idPedido, Integer idProducto, BigDecimal precio, String tieneOferta, String cveProducto, String nombreProducto, BigDecimal cantidad) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.precio = precio;
        this.tieneOferta = tieneOferta;
        this.cveProducto = cveProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public Integer getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(Integer idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public String getCveProducto() {
        return cveProducto;
    }

    public void setCveProducto(String cveProducto) {
        this.cveProducto = cveProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    
    

}

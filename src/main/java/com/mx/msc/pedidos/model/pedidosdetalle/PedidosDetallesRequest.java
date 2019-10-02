/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.pedidosdetalle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author chavon
 */
public class PedidosDetallesRequest {

    private Long idPedidoDetalle;

    private Long idPedido;

    @NotBlank(message = "El campo producto es requerido.")
    private Long idProducto;

    private Double precio;

    @Size(max = 1)
    private String tieneOferta;

    public Long getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(Long idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTieneOferta() {
        return tieneOferta;
    }

    public void setTieneOferta(String tieneOferta) {
        this.tieneOferta = tieneOferta;
    }

}

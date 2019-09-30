/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.pedidos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.msc.pedidos.model.PedidosDetalle.PedidosDetallesRequest;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chavon
 */
public class PedidosRequest {

    @NotNull
    private Long idPedido;

    @NotNull
    private Long idPeriodo;

    @NotNull
    private Long idCliente;

    @Temporal(value = TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @NotNull
    private Double total;

    @Size(max = 1)
    @NotBlank(message = "El campo estatus es requerido.")
    private String estatus;

    @JsonProperty(value = "pedidosDetalle")
    private List<PedidosDetallesRequest> pedidosDetalle;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public List<PedidosDetallesRequest> getPedidosDetalleRequest() {
        return pedidosDetalle;
    }

    public void setPedidosDetalleRequest(List<PedidosDetallesRequest> pedidosDetalle) {
        this.pedidosDetalle = pedidosDetalle;
    }

}

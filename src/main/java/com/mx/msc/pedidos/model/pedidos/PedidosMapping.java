/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.pedidos;

import java.util.Date;

/**
 *
 * @author salvadora
 */
public class PedidosMapping {

    private Integer idPedido;
    private String periodo;
    private String cliente;
    private String telefono;
    private String direccion;
    private String celular;
    private Date fecha;
    private String estatus;

    public PedidosMapping() {
    }

    public PedidosMapping(Integer idPedido, String periodo, String cliente, String telefono, String direccion, String celular, Date fecha, String estatus) {
        this.idPedido = idPedido;
        this.periodo = periodo;
        this.cliente = cliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.celular = celular;
        this.fecha = fecha;
        this.estatus = estatus;
    }
    
    

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

   
}

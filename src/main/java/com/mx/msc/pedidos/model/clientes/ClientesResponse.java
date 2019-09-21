/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.clientes;

/**
 *
 * @author chavon
 */
public class ClientesResponse {

    private Long idCliente;
    private String cveCliente;
    private String nombre;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(String cveCliente) {
        this.cveCliente = cveCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

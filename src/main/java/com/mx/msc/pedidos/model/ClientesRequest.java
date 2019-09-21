/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author chavon
 */
public class ClientesRequest {

    private Long idCliente;

    @NotBlank(message = "La clave del cliente es requerida.")
    @Size(max = 10, message = "La clave del cliente debe ser de maximo {max} caracteres.")
    private String cveCliente;

    @NotBlank(message = "El nombre es requerido.")
    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String direccion;

    @Size(max = 20)
    private String telefono;

    @Size(max = 20)
    private String celular;

    @Size(max = 1)
    private String activo;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

}

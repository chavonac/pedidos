/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.clientes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author chavon
 */
@Entity
@Table(name = "clientes")
public class ClientesModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idCliente;
    private String cveCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String activo;

    public ClientesModel() {
    }

    public ClientesModel(Long idCliente, String cveCliente, String nombre, String direccion, String telefono, String celular, String activo) {
        this.idCliente = idCliente;
        this.cveCliente = cveCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.activo = activo;
    }

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

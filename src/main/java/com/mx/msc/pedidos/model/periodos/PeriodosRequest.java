/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model.periodos;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author checo
 */
public class PeriodosRequest {

    private Long idPeriodo;

    @NotBlank(message = "La clave del periodo es requerida.")
    @Size(max = 10, message = "La longitud maxima es de {max} caracteres")
    private String cvePeriodo;

    @NotBlank(message = "El nombre es requerido.")
    @Size(max = 10)
    private String nombre;

    private Date fechaInicio;

    private Date fechaFin;

    @Size(max = 255)
    private String notas;

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
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

}

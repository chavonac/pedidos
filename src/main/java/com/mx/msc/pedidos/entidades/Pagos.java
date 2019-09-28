/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author checo
 */
@Entity
@Table(name = "pagos")
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;
    
    @Column(name="id_pedido")
    private Long idPedido;
    
    @Column(name="adeudo")
    private float adeudo;
    
    @Column(name="abono")
    private float abono;
    
    @Column(name="insoluto")
    private float insoluto;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="notas")
    private String notas;
    
    public Pagos(){}

    public Pagos(Long idPago, Long idPedido, float adeudo, float abono, float insoluto, Date fecha, String notas) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.adeudo = adeudo;
        this.abono = abono;
        this.insoluto = insoluto;
        this.fecha = fecha;
        this.notas = notas;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public float getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(float adeudo) {
        this.adeudo = adeudo;
    }

    public float getAbono() {
        return abono;
    }

    public void setAbono(float abono) {
        this.abono = abono;
    }

    public float getInsoluto() {
        return insoluto;
    }

    public void setInsoluto(float insoluto) {
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
    
    
}

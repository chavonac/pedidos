/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author chavon
 */
@Component
public class ResponseApi {

    private Boolean success;
    private String message;
    private Object data;

    public ResponseApi convierte(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
        return this;
    }

    public ResponseApi convierte(Boolean success, Object data) {
        this.success = success;
        this.message = "Proceso realizado correctamente";
        this.data = data;
        return this;
    }

    public ResponseApi convierte(Object data) {
        this.success = true;
        this.message = "Proceso realizado correctamente";
        this.data = data;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

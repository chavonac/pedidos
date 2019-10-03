/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.api;

import com.mx.msc.pedidos.entidades.Productos;
import com.mx.msc.pedidos.model.ResponseApi;
import com.mx.msc.pedidos.services.ProductosService;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sergiov
 */
@RestController
@RequestMapping("/api")
public class ProductosApi {

    @Autowired
    ProductosService productosService;

    @Autowired
    private ResponseApi responseApi;
    
    @Autowired
    Mapper mapper;
    
    @GetMapping("/productos")
    public ResponseApi getPeriodosAll() {
        List<Productos> periodos = productosService.getProductosAll();
        return responseApi.convierte(periodos);
    }

}

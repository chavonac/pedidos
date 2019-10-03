/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services;

import com.mx.msc.pedidos.entidades.Productos;
import com.mx.msc.pedidos.repository.ProductosRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergiov
 */
@Service
public class ProductosService {

    @Resource
    private ProductosRepository productosRepository;

    public List<Productos> getProductosAll() {
        return productosRepository.findAll();
    }

}

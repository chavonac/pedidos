/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.api;

import com.mx.msc.pedidos.entidades.Pedidos;
import com.mx.msc.pedidos.model.pedidos.PedidosRequest;
import com.mx.msc.pedidos.services.PedidosService;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chavon
 */
@RestController
@RequestMapping("/api")
public class PedidosApi {

    @Autowired
    Mapper mapper;

    @Autowired
    private PedidosService pedidosService;

    @PostMapping("/pedidos")
    public void insertaPedidos(@RequestBody @Valid List<Pedidos> pedidos) {
        for (Pedidos pedido : pedidos) {
            pedidosService.procesaPedidos(pedido);
        }

    }

}

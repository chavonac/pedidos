/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.api;

import com.mx.msc.pedidos.entidades.Pedidos;
import com.mx.msc.pedidos.model.ResponseApi;
import com.mx.msc.pedidos.services.PedidosService;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chavon
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class PedidosApi {

    @Autowired
    Mapper mapper;

    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private ResponseApi responseApi;

    @GetMapping("/pedidos")
    public ResponseApi getPedidos(@RequestParam(value = "nombreCliente") String nombreCliente) {
        return responseApi.convierte(pedidosService.getPedidos(nombreCliente));
    }

    @PostMapping("/pedidos")
    public void insertaPedidos(@RequestBody @Valid List<Pedidos> pedidos) {
        pedidos.forEach((pedido) -> {
            pedidosService.procesaPedidos(pedido);
        });

    }

}

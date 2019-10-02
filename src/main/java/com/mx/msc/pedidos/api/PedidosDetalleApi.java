/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.api;

import com.mx.msc.pedidos.entidades.PedidosDetalle;
import com.mx.msc.pedidos.model.ResponseApi;
import com.mx.msc.pedidos.model.pedidosdetalle.PedidosDetalleMapping;
import com.mx.msc.pedidos.services.PedidosDetalleService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sergiov
 */
@RestController
@RequestMapping("/api")
public class PedidosDetalleApi {

    @Autowired
    PedidosDetalleService pedidosDetalleService;

    @Autowired
    private ResponseApi responseApi;

    @Autowired
    Mapper mapper;

    @GetMapping("/pedidosDetalle")
    public ResponseApi getPedidosDetalleAll() {
        List<PedidosDetalle> pedidosDetalle = pedidosDetalleService.getPedidosDetalleAll();
        return responseApi.convierte(pedidosDetalle);
    }

    @GetMapping("/pedidosDetalleById")
    public ResponseApi getPedidosDetalleAll(@RequestParam(value = "idPedido") Integer idPedido) {
        List<PedidosDetalle> pedidosDetalle = pedidosDetalleService.getPedidosDetalleByPedido(idPedido);
        return responseApi.convierte(pedidosDetalle);
    }

    @PostMapping("/insertaPedidosDetalle")
    public ResponseApi insertaPedidosDetalle(@RequestBody @Valid List<PedidosDetalle> pedidosDetalle) {
        List<PedidosDetalleMapping> lista = new ArrayList<PedidosDetalleMapping>();
        pedidosDetalle.forEach((pedidoDetalle) -> {
            PedidosDetalle p = pedidosDetalleService.procesaPedidosDetalle(pedidoDetalle, "inserta");
            Integer idPedido,
                    idProducto;
            idPedido = p.getIdPedido().getIdPedido();
            idProducto = p.getIdProducto().getIdProducto();
            PedidosDetalleMapping registro = (PedidosDetalleMapping) pedidosDetalleService.getPedidosDetalleByPedidoProducto(idPedido, idProducto).get(0);
            lista.add(registro);
        });
        return responseApi.convierte(lista);
    }
    
    @PostMapping("/actualizaPedidosDetalle")
    public ResponseApi actualizaPedidosDetalle(@RequestBody @Valid List<PedidosDetalle> pedidosDetalle) {
        List<PedidosDetalleMapping> lista = new ArrayList<PedidosDetalleMapping>();
        pedidosDetalle.forEach((pedidoDetalle) -> {
            PedidosDetalle p = pedidosDetalleService.procesaPedidosDetalle(pedidoDetalle, "actualiza");
            Integer idPedido,
                    idProducto;
            idPedido = p.getIdPedido().getIdPedido();
            idProducto = p.getIdProducto().getIdProducto();
            PedidosDetalleMapping registro = (PedidosDetalleMapping) pedidosDetalleService.getPedidosDetalleByPedidoProducto(idPedido, idProducto).get(0);
            lista.add(registro);
        });
        return responseApi.convierte(lista);
    }
    
    @PostMapping("/eliminaPedidosDetalle")
    public ResponseApi eliminaPedidosDetalle(@RequestBody @Valid List<PedidosDetalle> pedidosDetalle) {
        pedidosDetalle.forEach((pedidoDetalle) -> {
            pedidosDetalleService.procesaPedidosDetalle(pedidoDetalle, "elimina");
        });
        return responseApi.convierte(true, "Proceso realizado correctamente", null);
    }
}

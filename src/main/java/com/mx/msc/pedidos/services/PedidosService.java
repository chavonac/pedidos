/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services;

import com.mx.msc.pedidos.entidades.Clientes;
import com.mx.msc.pedidos.entidades.Pedidos;
import com.mx.msc.pedidos.entidades.Periodos;
import com.mx.msc.pedidos.model.pedidos.PedidosRequest;
import com.mx.msc.pedidos.repository.PedidosRepository;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author chavon
 */
@Service
public class PedidosService {

    @Resource
    private PedidosRepository pedidosRepository;

    public void procesaPedidos(Pedidos pedido) {
        pedido = insertaPedidos(pedido);
    }

    private Pedidos insertaPedidos(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }
}

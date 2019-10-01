/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services;

import com.mx.msc.pedidos.entidades.Pedidos;
import com.mx.msc.pedidos.model.pedidos.PedidosMapping;
import com.mx.msc.pedidos.repository.PedidosRepository;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author chavon
 */
@Service
public class PedidosService {
    
    @Resource
    private PedidosRepository pedidosRepository;
    
    @PersistenceContext
    EntityManager em;
    
    public List getPedidos(String nombreCliente) {
        Query query = em.createQuery("Select new com.mx.msc.pedidos.model.pedidos.PedidosMapping("
                + "p.idPedido, "
                + "p.idPeriodo.nombre, "
                + "p.idCliente.nombre, "
                + "p.idCliente.telefono, "
                + "p.idCliente.direccion, "
                + "p.idCliente.celular, "
                + "p.fecha, "
                + "p.estatus"
                + ") "
                + "From Pedidos p "
                + "Where p.idCliente.nombre like :nombreCliente "
                + "order by p.idPedido"
                + "",
                 PedidosMapping.class);
        query.setParameter("nombreCliente", "%".concat(nombreCliente).concat("%"));
        List<PedidosMapping> list = query.getResultList();
        return list;
    }
    
    public void procesaPedidos(Pedidos pedido) {
        pedido = insertaPedidos(pedido);
    }
    
    private Pedidos insertaPedidos(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }
    
}

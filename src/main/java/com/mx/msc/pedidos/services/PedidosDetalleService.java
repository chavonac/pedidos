/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services;

import com.mx.msc.pedidos.entidades.PedidosDetalle;
import com.mx.msc.pedidos.model.pedidosdetalle.PedidosDetalleMapping;
import com.mx.msc.pedidos.repository.PedidosDetalleRepository;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author sergiov
 */
@Service
public class PedidosDetalleService {
    
    @Resource
    private PedidosDetalleRepository pedidosDetalleRepository;
    
    @PersistenceContext
    EntityManager em;
    
     public PedidosDetalle getPedidoDetalleById(Integer idPedidoDetalle) {
        return pedidosDetalleRepository.findById(idPedidoDetalle).orElse(null);
    }
    
    public List getPedidosDetalleAll() {
        Query query = em.createQuery("Select new com.mx.msc.pedidos.model.pedidosdetalle.PedidosDetalleMapping("
                + "pd.idPedidoDetalle, "
                + "pd.idPedido.idPedido, "
                + "pd.idProducto.idProducto, "
                + "pd.precio, "
                + "pd.tieneOferta, "
                + "pd.idProducto.cveProducto, "
                + "pd.idProducto.nombre, "
                + "pd.cantidad"
                + ") "
                + "From PedidosDetalle pd "
                + "order by pd.idPedidoDetalle"
                + "",
                 PedidosDetalleMapping.class);
        List<PedidosDetalleMapping> list = query.getResultList();
        return list;
    }
    
    public List getPedidosDetalleByPedido(Integer idPedido) {
        Query query = em.createQuery("Select new com.mx.msc.pedidos.model.pedidosdetalle.PedidosDetalleMapping("
                + "pd.idPedidoDetalle, "
                + "pd.idPedido.idPedido, "
                + "pd.idProducto.idProducto, "
                + "pd.precio, "
                + "pd.tieneOferta, "
                + "pd.idProducto.cveProducto, "
                + "pd.idProducto.nombre, "
                + "pd.cantidad"
                + ") "
                + "From PedidosDetalle pd "
                + "Where pd.idPedido.idPedido = :idPedido "
                 + "order by pd.idPedidoDetalle"
                + "",
                 PedidosDetalleMapping.class);
        query.setParameter("idPedido", idPedido);
        List<PedidosDetalleMapping> list = query.getResultList();
        return list;
    }
    
    public List getPedidosDetalleByPedidoProducto(Integer idPedido, Integer idProducto) {
        Query query = em.createQuery("Select new com.mx.msc.pedidos.model.pedidosdetalle.PedidosDetalleMapping("
                + "pd.idPedidoDetalle, "
                + "pd.idPedido.idPedido, "
                + "pd.idProducto.idProducto, "
                + "pd.precio, "
                + "pd.tieneOferta, "
                + "pd.idProducto.cveProducto, "
                + "pd.idProducto.nombre, "
                + "pd.cantidad"
                + ") "
                + "From PedidosDetalle pd "
                + "Where pd.idPedido.idPedido = :idPedido "
                + "and pd.idProducto.idProducto = :idProducto "
                 + "order by pd.idPedidoDetalle"
                + "",
                 PedidosDetalleMapping.class);
        query.setParameter("idPedido", idPedido);
        query.setParameter("idProducto", idProducto);
        List<PedidosDetalleMapping> list = query.getResultList();
        return list;
    }
    
     public PedidosDetalle procesaPedidosDetalle(PedidosDetalle pedidoDetalle, String operacion) {
        switch (operacion) {
            case "inserta":
                pedidoDetalle = this.insertaPedidoDetalle(pedidoDetalle);
                break;
            case "actualiza":
                pedidoDetalle = this.actualizaPedidoDetalle(pedidoDetalle);
                break;
            case "elimina":
                this.eliminaPedidoDetalle(pedidoDetalle);
                break;
        }
        return pedidoDetalle;
    }

    private PedidosDetalle insertaPedidoDetalle(PedidosDetalle periodo) {
        return pedidosDetalleRepository.save(periodo);
    }
    
     public PedidosDetalle actualizaPedidoDetalle(PedidosDetalle pedidoDetalle) {
        PedidosDetalle pedidoDetalleAnt = this.getPedidoDetalleById(pedidoDetalle.getIdPedidoDetalle());
        PedidosDetalle pedidoDetalleAct;
        if (pedidoDetalleAnt != null) {
            pedidoDetalleAnt.setIdPedido(pedidoDetalle.getIdPedido());
            pedidoDetalleAnt.setIdProducto(pedidoDetalle.getIdProducto());
            pedidoDetalleAnt.setPrecio(pedidoDetalle.getPrecio());
            pedidoDetalleAnt.setTieneOferta(pedidoDetalle.getTieneOferta());
            pedidoDetalleAnt.setCantidad(pedidoDetalle.getCantidad());
            pedidosDetalleRepository.save(pedidoDetalleAnt);
            pedidoDetalleAct = pedidoDetalleAnt;
        }else{
            pedidoDetalleAct = new PedidosDetalle();
        }
        return pedidoDetalleAct;

    }
     
     private void eliminaPedidoDetalle(PedidosDetalle pedidoDetalle) {
        pedidosDetalleRepository.delete(pedidosDetalleRepository.findById(pedidoDetalle.getIdPedidoDetalle()).orElse(null));
    }
    
}


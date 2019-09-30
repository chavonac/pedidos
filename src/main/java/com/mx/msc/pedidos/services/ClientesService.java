/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services;

import com.mx.msc.pedidos.entidades.Clientes;
import com.mx.msc.pedidos.model.clientes.ClientesRequest;
import com.mx.msc.pedidos.repository.ClientesRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

/**
 *
 * @author chavon
 */
@Service
public class ClientesService {

    @Resource
    private ClientesRepository clientesRepository;

    public List<Clientes> getClienteByCve(String cveCliente) {
        List<Clientes> list = clientesRepository.clienteByClave(cveCliente);
        list.forEach(l -> System.out.println(l));
        return list;
    }

    public List<Clientes> filtraClientes(String cveCliente, String nombre, String activo) {
        return clientesRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (cveCliente != null && !cveCliente.isEmpty()) {
                predicates.add(cb.and(cb.like(root.get("cveCliente"), cveCliente)));
            }
            if (nombre != null && !nombre.isEmpty()) {
                predicates.add(cb.and(cb.like(root.get("nombre"), "%" + nombre + "%")));
            }
            if (activo != null && !activo.isEmpty()) {
                predicates.add(cb.and(cb.like(root.get("activo"), activo)));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
    }

    public Clientes insertaCliente(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    public Clientes actualizaCliente(Clientes cliente, ClientesRequest clientesRequest) {
        cliente.setCveCliente(clientesRequest.getCveCliente());
        cliente.setNombre(clientesRequest.getNombre());
        cliente.setDireccion(clientesRequest.getDireccion());
        cliente.setTelefono(clientesRequest.getTelefono());
        cliente.setCelular(clientesRequest.getCelular());
        cliente.setActivo(clientesRequest.getActivo());
        return clientesRepository.save(cliente);
    }

    public void eliminaCliente(Integer idCliente) throws Exception {
        clientesRepository.delete(clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro ningun Cliente con el id ::" + idCliente)));
    }

}

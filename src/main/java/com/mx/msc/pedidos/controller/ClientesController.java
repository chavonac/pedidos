/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.controller;

import com.mx.msc.pedidos.model.clientes.ClientesModel;
import com.mx.msc.pedidos.model.clientes.ClientesRequest;
import com.mx.msc.pedidos.model.clientes.ClientesResponse;
import com.mx.msc.pedidos.repository.clientes.ClientesRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chavon
 */
@RestController
@RequestMapping("/api")
public class ClientesController {

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    Mapper mapper;

    @PersistenceContext
    private EntityManager em;

    @GetMapping("/clientes")
    public List<ClientesModel> getAllClientes() {
        return clientesRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseBody
    public ClientesModel getClienteById(@PathVariable(value = "id") Long idCliente) throws Exception {
        return clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro ningun Cliente con el id ::" + idCliente));
    }

    @GetMapping("/clientesByClave/{cveCliente}")
    public void findAll(@PathVariable(value = "cveCliente") String cveCliente) {
        Query query = em.createNativeQuery("SELECT id_cliente, cve_cliente, nombre FROM clientes WHERE cve_cliente = :cveCliente");
        query.setParameter("cveCliente", cveCliente);
        List<Object[]> results = query.getResultList();
    }

    @PostMapping("/clientes")
    public ClientesResponse crearCliente(@RequestBody @Valid ClientesRequest clientesRequest) {
        // Mapeo request dto ==> entity
        ClientesModel clientes = mapper.map(clientesRequest, ClientesModel.class);

        // Invoca l[ogica de negocio
        ClientesModel updatedCliente = clientesRepository.save(clientes);

        // Mapeo entity ==> response dto
        ClientesResponse clientesResponse = mapper.map(updatedCliente, ClientesResponse.class);

        return clientesResponse;
    }

    @PutMapping("/clientes/{id}")
    public ClientesResponse getActualizaCliente(@PathVariable(value = "id") Long idCliente, @RequestBody String direccion) throws Exception {
        ClientesModel cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro el cliente con el id :: " + idCliente));
        cliente.setDireccion(direccion);
        ClientesModel updatedCliente = clientesRepository.save(cliente);
        ClientesResponse clientesResponse = mapper.map(updatedCliente, ClientesResponse.class);
        return clientesResponse;
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long idCliente) throws Exception {
        ClientesModel cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro ningun Cliente con el id ::" + idCliente));
        clientesRepository.delete(cliente);
        return ResponseEntity.ok().build();
    }
}

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
import java.util.Optional;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/clientes")
    public List<ClientesModel> getAllClientes() {
        return clientesRepository.findAll();
    }

    @GetMapping("/getClienteById")
    @ResponseBody
    public Optional<ClientesModel> getClienteById(@RequestParam Long idCliente) {
        return clientesRepository.findById(idCliente);
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

    @PutMapping("/clientes")
    public ClientesResponse getActualizaCliente(@PathVariable Long idCliente, @PathVariable String direccion) throws Exception {
        ClientesModel cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("Employee not found for this id :: " + idCliente));

        cliente.setDireccion(direccion);

        ClientesModel updatedCliente = clientesRepository.save(cliente);

        ClientesResponse clientesResponse = mapper.map(updatedCliente, ClientesResponse.class);

        return clientesResponse;
    }
}

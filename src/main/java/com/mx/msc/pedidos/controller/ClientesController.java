/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.controller;

import com.mx.msc.pedidos.model.ClientesModel;
import com.mx.msc.pedidos.model.ClientesRequest;
import com.mx.msc.pedidos.model.ClientesResponse;
import com.mx.msc.pedidos.repository.ClientesRepository;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ClientesController {

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    Mapper mapper;

    @GetMapping("/clientes")
    public List<ClientesModel> getAllClientes() {
        return clientesRepository.findAll();
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

}

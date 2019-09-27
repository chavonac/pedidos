/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*https://www.baeldung.com/spring-data-jpa-query
*https://www.baeldung.com/spring-request-param
*https://javadeveloperzone.com/spring/spring-jpa-dynamic-query-example/
 */
package com.mx.msc.pedidos.controller;

import com.mx.msc.pedidos.entidades.Clientes;
import com.mx.msc.pedidos.model.clientes.ClientesRequest;
import com.mx.msc.pedidos.model.clientes.ClientesResponse;
import com.mx.msc.pedidos.repository.ClientesRepository;
import com.mx.msc.pedidos.services.ClientesService;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/clientes")
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseBody
    public Clientes getClienteById(@PathVariable(value = "id") Long idCliente) throws Exception {
        return clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro ningun Cliente con el id ::" + idCliente));
    }

    @GetMapping("/clientesByClave/{cveCliente}")
    public ResponseEntity<List<Clientes>> findClienteByCveCliente(@PathVariable(value = "cveCliente") String cveCliente) {
        return new ResponseEntity<>(clientesService.getClienteByCve(cveCliente), HttpStatus.OK);
    }

    @GetMapping("/clientesByFilter")
    public ResponseEntity<List<Clientes>> findClienteByFilter(
            @RequestParam(value = "cveCliente") String cveCliente,
            @RequestParam(value = "nombre") String nombre,
            @RequestParam(value = "activo") String activo
    ) {
        return new ResponseEntity<>(clientesService.filtraClientes(cveCliente, nombre, activo), HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ClientesResponse crearCliente(@RequestBody @Valid ClientesRequest clientesRequest) {
        Clientes clientes = mapper.map(clientesRequest, Clientes.class);
        Clientes updatedCliente = clientesRepository.save(clientes);
        ClientesResponse clientesResponse = mapper.map(updatedCliente, ClientesResponse.class);
        return clientesResponse;
    }

    @PutMapping("/clientes/{id}")
    public ClientesResponse getActualizaCliente(@PathVariable(value = "id") Long idCliente, @RequestBody @Valid ClientesRequest clientesRequest) throws Exception {
        Clientes cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro el cliente con el id :: " + idCliente));
        cliente.setCveCliente(clientesRequest.getCveCliente());
        cliente.setNombre(clientesRequest.getNombre());
        cliente.setDireccion(clientesRequest.getDireccion());
        cliente.setTelefono(clientesRequest.getTelefono());
        cliente.setCelular(clientesRequest.getCelular());
        cliente.setActivo(clientesRequest.getActivo());
        Clientes updatedCliente = clientesRepository.save(cliente);
        ClientesResponse clientesResponse = mapper.map(updatedCliente, ClientesResponse.class);
        return clientesResponse;
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long idCliente) throws Exception {
        Clientes cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro ningun Cliente con el id ::" + idCliente));
        clientesRepository.delete(cliente);
        return ResponseEntity.ok().build();
    }
}

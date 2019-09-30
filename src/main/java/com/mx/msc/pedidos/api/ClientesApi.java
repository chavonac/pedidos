/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*https://www.baeldung.com/spring-data-jpa-query
*https://www.baeldung.com/spring-request-param
*https://javadeveloperzone.com/spring/spring-jpa-dynamic-query-example/
 */
package com.mx.msc.pedidos.api;

import com.mx.msc.pedidos.entidades.Clientes;
import com.mx.msc.pedidos.model.ResponseApi;
import com.mx.msc.pedidos.model.clientes.ClientesRequest;
import com.mx.msc.pedidos.model.clientes.ClientesResponse;
import com.mx.msc.pedidos.repository.ClientesRepository;
import com.mx.msc.pedidos.services.ClientesService;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClientesApi {

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    Mapper mapper;

    @Autowired
    private ResponseApi responseApi;

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/clientes")
    public ResponseApi getAllClientes() {
        return responseApi.convierte(clientesRepository.findAll());
    }

    @GetMapping("/clientes/{id}")
    @ResponseBody
    public ResponseApi getClienteById(@PathVariable(value = "id") Integer idCliente) throws Exception {
        Clientes cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro ningun Cliente con el id ::" + idCliente));
        return responseApi.convierte(cliente);
    }

    @GetMapping("/clientesByClave/{cveCliente}")
    public ResponseApi findClienteByCveCliente(@PathVariable(value = "cveCliente") String cveCliente) {
        List<Clientes> clientes = clientesService.getClienteByCve(cveCliente);
        return responseApi.convierte(clientes);
    }

    @GetMapping("/clientesByFilter")
    public ResponseApi findClienteByFilter(@RequestParam(value = "cveCliente") String cveCliente, @RequestParam(value = "nombre") String nombre, @RequestParam(value = "activo") String activo) {
        List<Clientes> clientes = clientesService.filtraClientes(cveCliente, nombre, activo);
        return responseApi.convierte(clientes);
    }

    @PostMapping("/clientes")
    public ResponseApi insertaCliente(@RequestBody @Valid ClientesRequest clientesRequest) {
        ClientesResponse cliente = mapper.map(clientesService.insertaCliente(mapper.map(clientesRequest, Clientes.class)), ClientesResponse.class);
        return responseApi.convierte(cliente);
    }

    @PutMapping("/clientes/{id}")
    public ResponseApi actualizaCliente(@PathVariable(value = "id") Integer idCliente, @RequestBody @Valid ClientesRequest clientesRequest) throws Exception {

        Clientes cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new Exception("No se encontro el cliente con el id :: " + idCliente));
        cliente = clientesService.actualizaCliente(cliente, clientesRequest);
        return responseApi.convierte(mapper.map(cliente, ClientesResponse.class));
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseApi eliminaCliente(@PathVariable(value = "id") Integer idCliente) throws Exception {
        clientesService.eliminaCliente(idCliente);
        return responseApi.convierte(null);
    }
}

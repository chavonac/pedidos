/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services.clientes;

import com.mx.msc.pedidos.model.clientes.ClientesModel;
import com.mx.msc.pedidos.repository.clientes.ClientesRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author salvadora
 */
@Service
public class ClientesService {

    @Resource
    private ClientesRepository clientesRepository;

    public List<ClientesModel> getClienteByCve(String cveCliente) {
        List<ClientesModel> list = clientesRepository.clienteByClave(cveCliente);
        list.forEach(l -> System.out.println(l));
        return list;
    }
}

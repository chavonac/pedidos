/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.repository.clientes;

import com.mx.msc.pedidos.model.clientes.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chavon
 */
public interface ClientesRepository extends JpaRepository<ClientesModel, Long>{
    
}

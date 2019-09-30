/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.repository;

import com.mx.msc.pedidos.entidades.Clientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chavon
 */
public interface ClientesRepository extends JpaRepository<Clientes, Integer>, JpaSpecificationExecutor<Clientes>{

    @Query("SELECT t FROM Clientes t WHERE t.cveCliente = :cveCliente")
    List<Clientes> clienteByClave(String cveCliente);

}

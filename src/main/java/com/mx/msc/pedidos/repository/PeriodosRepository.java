/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.repository;

import com.mx.msc.pedidos.entidades.Periodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author checo
 */
public interface PeriodosRepository extends JpaRepository<Periodos, Integer>, JpaSpecificationExecutor<Periodos> {

}

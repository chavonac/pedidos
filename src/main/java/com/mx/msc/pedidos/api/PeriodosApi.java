/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.api;

import com.mx.msc.pedidos.entidades.Periodos;
import com.mx.msc.pedidos.model.ResponseApi;
import com.mx.msc.pedidos.services.PeriodosService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author checo
 */
@RestController
@RequestMapping("/api")
public class PeriodosApi {

    @Autowired
    PeriodosService periodosService;

    @Autowired
    private ResponseApi responseApi;

    @Autowired
    Mapper mapper;

    @GetMapping("/periodos")
    public ResponseApi getPeriodosAll() {
        List<Periodos> periodos = periodosService.getPeriodosAll();
        return responseApi.convierte(periodos);
    }

    @GetMapping("/periodosByFecha")
    public ResponseEntity<List<Periodos>> findClienteByFilter(@RequestParam(value = "fecha") String fecha) {
        return new ResponseEntity<>(periodosService.getPeriodosByFecha(fecha), HttpStatus.OK);
    }

    @PostMapping("/insertaPeriodos")
    public ResponseApi insertaPeriodos(@RequestBody @Valid List<Periodos> periodos) {
        List<Periodos> lista = new ArrayList<Periodos>();
        periodos.forEach((periodo) -> {
            lista.add(periodosService.procesaPeriodos(periodo, "inserta"));
        });
        return responseApi.convierte(lista);
    }
    
    @PostMapping("/actualizaPeriodos")
    public ResponseApi actualizaPeriodos(@RequestBody @Valid List<Periodos> periodos) {
        List<Periodos> lista = new ArrayList<Periodos>();
        periodos.forEach((periodo) -> {
            lista.add(periodosService.procesaPeriodos(periodo, "actualiza"));
        });
        return responseApi.convierte(lista);
    }
    
    @PostMapping("/eliminaPeriodos")
    public ResponseApi eliminaPeriodos(@RequestBody @Valid List<Periodos> periodos) {
        List<Periodos> lista = new ArrayList<Periodos>();
        periodos.forEach((periodo) -> {
            lista.add(periodosService.procesaPeriodos(periodo, "elimina"));
        });
        return responseApi.convierte(true, "Proceso realizado correctamente", null);
    }

}

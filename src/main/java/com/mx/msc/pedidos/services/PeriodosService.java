/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.msc.pedidos.services;

import com.mx.msc.pedidos.entidades.Periodos;
import com.mx.msc.pedidos.repository.PeriodosRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author checo
 */
@Service
public class PeriodosService {

    @Resource
    private PeriodosRepository periodosRepository;

    @PersistenceContext
    EntityManager em;

    public List<Periodos> getPeriodosAll() {
        return periodosRepository.findAll();
    }

    public Periodos getPeriodoById(Integer idPeriodo) {
        return periodosRepository.findById(idPeriodo).orElse(null);
    }

    public List getPeriodosByFecha(String fecha) {
        List lista = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Query query = em.createQuery("select p from Periodos p where :fecha between p.fechaInicio and p.fechaFin");
            query.setParameter("fecha", sdf.parse(fecha));
            lista = query.getResultList();
        } catch (ParseException ex) {
            Logger.getLogger(PeriodosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Periodos procesaPeriodos(Periodos periodo, String operacion) {
        switch (operacion) {
            case "inserta":
                periodo = this.insertaPeriodo(periodo);
                break;
            case "actualiza":
                periodo = this.actualizaPeriodo(periodo);
                break;
            case "elimina":
                this.eliminaPeriodo(periodo);
                break;
        }
        return periodo;
    }

    private Periodos insertaPeriodo(Periodos periodo) {
        return periodosRepository.save(periodo);
    }

    public Periodos actualizaPeriodo(Periodos periodo) {
        Periodos periodoAnt = this.getPeriodoById(periodo.getIdPeriodo());
        Periodos periodoAct;
        if (periodoAnt != null) {
            periodoAnt.setNombre(periodo.getNombre());
            periodoAnt.setFechaInicio(periodo.getFechaInicio());
            periodoAnt.setFechaFin(periodo.getFechaFin());
            periodoAnt.setNotas(periodo.getNotas());
            periodosRepository.save(periodoAnt);
            periodoAct = periodoAnt;
        }else{
            periodoAct = new Periodos();
        }
        return periodoAct;

    }
    
    private void eliminaPeriodo(Periodos periodo) {
        periodosRepository.delete(periodosRepository.findById(periodo.getIdPeriodo()).orElse(null));
    }

}

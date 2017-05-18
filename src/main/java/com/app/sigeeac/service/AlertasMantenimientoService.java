/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.AlertasMantenimientoDao;
import com.app.sigeeac.model.AlertasMantenimiento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luish
 */
@Service
@Transactional
public class AlertasMantenimientoService {
    @Autowired
    private final AlertasMantenimientoDao amRepository;
    
    public AlertasMantenimientoService(AlertasMantenimientoDao amr){
        this.amRepository = amr;
    }
    
    public  List<AlertasMantenimiento> findAll(){
        List<AlertasMantenimiento> alertas = new ArrayList<>();
        for(AlertasMantenimiento alerta : amRepository.findAll()){
            alertas.add(alerta);
        }
        return alertas;
    }
    
    public AlertasMantenimiento findOne(Integer id){
        return amRepository.findOne(id);
    }
    public void save(AlertasMantenimiento am){
        amRepository.save(am);
    }
    public void delete(Integer id){
        amRepository.delete(id);
    }
}

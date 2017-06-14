/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.TipoMantenimientoDao;
import com.app.sigeeac.model.TipoMantenimiento;
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
public class TipoMantenimientoService {
    @Autowired
    private final TipoMantenimientoDao myRepository;
    
    public TipoMantenimientoService(TipoMantenimientoDao dao){
        this.myRepository = dao;
    }
    
    public  List<TipoMantenimiento> findAll(){
        List<TipoMantenimiento> registros = new ArrayList<>();
        for(TipoMantenimiento item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public TipoMantenimiento findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(TipoMantenimiento newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

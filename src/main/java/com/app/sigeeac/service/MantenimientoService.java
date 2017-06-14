/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.MantenimientoDao;
import com.app.sigeeac.model.Mantenimiento;
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
public class MantenimientoService {
    @Autowired
    private final MantenimientoDao myRepository;
    
    public MantenimientoService(MantenimientoDao dao){
        this.myRepository = dao;
    }
    
    public  List<Mantenimiento> findAll(){
        List<Mantenimiento> registros = new ArrayList<>();
        for(Mantenimiento item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public Mantenimiento findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(Mantenimiento newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

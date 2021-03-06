/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.EquipoTrabajoDao;
import com.app.sigeeac.model.EquipoTrabajo;
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
public class EquipoTrabajoService {
    @Autowired
    private final EquipoTrabajoDao myRepository;
    
    public EquipoTrabajoService(EquipoTrabajoDao dao){
        this.myRepository = dao;
    }
    
    public  List<EquipoTrabajo> findAll(){
        List<EquipoTrabajo> registros = new ArrayList<>();
        for(EquipoTrabajo item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public EquipoTrabajo findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(EquipoTrabajo newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

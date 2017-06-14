/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.EquipoElectricoDao;
import com.app.sigeeac.model.EquipoElectrico;
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
public class EquipoElectricoService {
    @Autowired
    private final EquipoElectricoDao myRepository;
    
    public EquipoElectricoService(EquipoElectricoDao dao){
        this.myRepository = dao;
    }
    
    public  List<EquipoElectrico> findAll(){
        List<EquipoElectrico> registros = new ArrayList<>();
        for(EquipoElectrico item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public EquipoElectrico findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(EquipoElectrico newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

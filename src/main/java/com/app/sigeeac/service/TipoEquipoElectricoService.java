/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.TipoEquipoElectricoDao;
import com.app.sigeeac.model.TipoEquipoElectrico;
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
public class TipoEquipoElectricoService {
    @Autowired
    private final TipoEquipoElectricoDao myRepository;
    
    public TipoEquipoElectricoService(TipoEquipoElectricoDao dao){
        this.myRepository = dao;
    }
    
    public  List<TipoEquipoElectrico> findAll(){
        List<TipoEquipoElectrico> registros = new ArrayList<>();
        for(TipoEquipoElectrico item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public TipoEquipoElectrico findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(TipoEquipoElectrico newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

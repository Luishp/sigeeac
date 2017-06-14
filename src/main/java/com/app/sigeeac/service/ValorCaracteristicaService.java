/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.ValorCaracteristicaDao;
import com.app.sigeeac.model.ValorCaracteristica;
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
public class ValorCaracteristicaService {
    @Autowired
    private final ValorCaracteristicaDao myRepository;
    
    public ValorCaracteristicaService(ValorCaracteristicaDao dao){
        this.myRepository = dao;
    }
    
    public  List<ValorCaracteristica> findAll(){
        List<ValorCaracteristica> registros = new ArrayList<>();
        for(ValorCaracteristica item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public ValorCaracteristica findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(ValorCaracteristica newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

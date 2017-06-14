/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.CaracteristicaDao;
import com.app.sigeeac.model.Caracteristica;
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
public class CaracteristicaService {
    @Autowired
    private final CaracteristicaDao myRepository;
    
    public CaracteristicaService(CaracteristicaDao dao){
        this.myRepository = dao;
    }
    
    public  List<Caracteristica> findAll(){
        List<Caracteristica> registros = new ArrayList<>();
        for(Caracteristica item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public Caracteristica findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(Caracteristica newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

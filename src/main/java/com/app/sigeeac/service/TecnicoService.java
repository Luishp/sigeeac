/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.TecnicoDao;
import com.app.sigeeac.model.Tecnico;
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
public class TecnicoService {
    @Autowired
    private final TecnicoDao myRepository;
    
    public TecnicoService(TecnicoDao dao){
        this.myRepository = dao;
    }
    
    public  List<Tecnico> findAll(){
        List<Tecnico> registros = new ArrayList<>();
        for(Tecnico item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public Tecnico findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(Tecnico newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.TecnicoBloqueadoDao;
import com.app.sigeeac.model.TecnicoBloqueado;
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
public class TecnicoBloqueadoService {
    @Autowired
    private final TecnicoBloqueadoDao myRepository;
    
    public TecnicoBloqueadoService(TecnicoBloqueadoDao dao){
        this.myRepository = dao;
    }
    
    public  List<TecnicoBloqueado> findAll(){
        List<TecnicoBloqueado> registros = new ArrayList<>();
        for(TecnicoBloqueado item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public TecnicoBloqueado findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(TecnicoBloqueado newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.TipoServicioDao;
import com.app.sigeeac.model.TipoServicio;
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
public class TipoServicioService {
    @Autowired
    private final TipoServicioDao myRepository;
    
    public TipoServicioService(TipoServicioDao dao){
        this.myRepository = dao;
    }
    
    public  List<TipoServicio> findAll(){
        List<TipoServicio> registros = new ArrayList<>();
        for(TipoServicio item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public TipoServicio findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(TipoServicio newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

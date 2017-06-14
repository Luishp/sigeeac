/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.ServicioOfrecidoDao;
import com.app.sigeeac.model.ServicioOfrecido;
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
public class ServicioOfrecidoService {
    @Autowired
    private final ServicioOfrecidoDao myRepository;
    
    public ServicioOfrecidoService(ServicioOfrecidoDao dao){
        this.myRepository = dao;
    }
    
    public  List<ServicioOfrecido> findAll(){
        List<ServicioOfrecido> registros = new ArrayList<>();
        for(ServicioOfrecido item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public ServicioOfrecido findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(ServicioOfrecido newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

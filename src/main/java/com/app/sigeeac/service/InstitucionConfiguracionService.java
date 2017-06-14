/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.InstitucionConfiguracionDao;
import com.app.sigeeac.model.InstitucionConfiguracion;
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
public class InstitucionConfiguracionService {
    @Autowired
    private final InstitucionConfiguracionDao myRepository;
    
    public InstitucionConfiguracionService(InstitucionConfiguracionDao dao){
        this.myRepository = dao;
    }
    
    public  List<InstitucionConfiguracion> findAll(){
        List<InstitucionConfiguracion> registros = new ArrayList<>();
        for(InstitucionConfiguracion item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public InstitucionConfiguracion findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(InstitucionConfiguracion newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

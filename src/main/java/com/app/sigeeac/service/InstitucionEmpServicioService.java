/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.InstitucionEmpServicioDao;
import com.app.sigeeac.model.InstitucionEmpServicio;
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
public class InstitucionEmpServicioService {
    @Autowired
    private final InstitucionEmpServicioDao myRepository;
    
    public InstitucionEmpServicioService(InstitucionEmpServicioDao dao){
        this.myRepository = dao;
    }
    
    public  List<InstitucionEmpServicio> findAll(){
        List<InstitucionEmpServicio> registros = new ArrayList<>();
        for(InstitucionEmpServicio item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public InstitucionEmpServicio findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(InstitucionEmpServicio newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

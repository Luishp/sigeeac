/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.EmpresaServicioDao;
import com.app.sigeeac.model.EmpresaServicio;
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
public class EmpresaServicioService {
    @Autowired
    private final EmpresaServicioDao myRepository;
    
    public EmpresaServicioService(EmpresaServicioDao dao){
        this.myRepository = dao;
    }
    
    public  List<EmpresaServicio> findAll(){
        List<EmpresaServicio> registros = new ArrayList<>();
        for(EmpresaServicio item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public EmpresaServicio findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(EmpresaServicio newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.SolicitudCompraDao;
import com.app.sigeeac.model.SolicitudCompra;
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
public class SolicitudCompraService {
    @Autowired
    private final SolicitudCompraDao myRepository;
    
    public SolicitudCompraService(SolicitudCompraDao dao){
        this.myRepository = dao;
    }
    
    public  List<SolicitudCompra> findAll(){
        List<SolicitudCompra> registros = new ArrayList<>();
        for(SolicitudCompra item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public SolicitudCompra findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(SolicitudCompra newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

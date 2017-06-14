/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.OrdenCompraDao;
import com.app.sigeeac.model.OrdenCompra;
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
public class OrdenCompraService {
    @Autowired
    private final OrdenCompraDao myRepository;
    
    public OrdenCompraService(OrdenCompraDao dao){
        this.myRepository = dao;
    }
    
    public  List<OrdenCompra> findAll(){
        List<OrdenCompra> registros = new ArrayList<>();
        for(OrdenCompra item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public OrdenCompra findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(OrdenCompra newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

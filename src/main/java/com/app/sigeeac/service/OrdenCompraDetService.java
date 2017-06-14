/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.OrdenCompraDetDao;
import com.app.sigeeac.model.OrdenCompraDet;
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
public class OrdenCompraDetService {
    @Autowired
    private final OrdenCompraDetDao myRepository;
    
    public OrdenCompraDetService(OrdenCompraDetDao dao){
        this.myRepository = dao;
    }
    
    public  List<OrdenCompraDet> findAll(){
        List<OrdenCompraDet> registros = new ArrayList<>();
        for(OrdenCompraDet item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public OrdenCompraDet findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(OrdenCompraDet newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

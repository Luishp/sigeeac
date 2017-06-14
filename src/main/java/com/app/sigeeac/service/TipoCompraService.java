/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.TipoCompraDao;
import com.app.sigeeac.model.TipoCompra;
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
public class TipoCompraService {
    @Autowired
    private final TipoCompraDao myRepository;
    
    public TipoCompraService(TipoCompraDao dao){
        this.myRepository = dao;
    }
    
    public  List<TipoCompra> findAll(){
        List<TipoCompra> registros = new ArrayList<>();
        for(TipoCompra item : myRepository.findAll()){
            registros.add(item);
        }
        return registros;
    }
    
    public TipoCompra findOne(Integer id){
        return myRepository.findOne(id);
    }
    public void save(TipoCompra newRecord){
        myRepository.save(newRecord);
    }
    public void delete(Integer id){
        myRepository.delete(id);
    }
}

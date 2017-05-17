/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.SusuarioDao;
import com.app.sigeeac.model.Susuario;
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
public class SusuarioService {
    @Autowired
    private final SusuarioDao suRepository;
    
    public SusuarioService(SusuarioDao userRep){
        this.suRepository = userRep;
    }
    
    public  List<Susuario> findAll(){
        List<Susuario> usuarios = new ArrayList<>();
        for(Susuario usuario : suRepository.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }
    
    public Susuario findOne(Integer id){
        return suRepository.findOne(id);
    }
    public void save(Susuario ig){
        suRepository.save(ig);
    }
    public void delete(Integer id){
        suRepository.delete(id);
    }
}

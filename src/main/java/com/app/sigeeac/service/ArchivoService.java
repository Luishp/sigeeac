/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.service;

import com.app.sigeeac.dao.ArchivoDao;
import com.app.sigeeac.model.Archivo;
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
public class ArchivoService {
    @Autowired
    private final ArchivoDao archivoRepository;
    
    public ArchivoService(ArchivoDao ad){
        this.archivoRepository = ad;
    }
    
    public  List<Archivo> findAll(){
        List<Archivo> archivos = new ArrayList<>();
        for(Archivo archivo : archivoRepository.findAll()){
            archivos.add(archivo);
        }
        return archivos;
    }
    
    public Archivo findOne(Integer id){
        return archivoRepository.findOne(id);
    }
    public void save(Archivo ig){
        archivoRepository.save(ig);
    }
    public void delete(Integer id){
        archivoRepository.delete(id);
    }
}

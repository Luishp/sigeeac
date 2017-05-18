/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Archivo;
import com.app.sigeeac.service.ArchivoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luish
 */
@RestController
@RequestMapping("/archivo")
public class ArchivoRest {
    @Autowired
    private ArchivoService archivoService;
    
    @RequestMapping("/all")
    public List<Archivo> getAllArchivo(){
        return archivoService.findAll();
    }
    @RequestMapping("getById/{id}")
    public Archivo getArchivoById(@PathVariable("id") String id){
        return archivoService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addArchivo(@RequestBody Archivo archivo){
        archivoService.save(archivo);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateArchivo(@RequestBody Archivo archivo, @PathVariable("id") String id){
        archivoService.save(archivo);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteArchivo(@PathVariable("id") String id){
        archivoService.delete(Integer.parseInt(id));
    }
}

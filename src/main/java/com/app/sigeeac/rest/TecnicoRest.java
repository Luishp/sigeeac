/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Tecnico;
import com.app.sigeeac.service.TecnicoService;
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
@RequestMapping("/tecnico")
public class TecnicoRest {
    @Autowired
    private TecnicoService myService;
    
    @RequestMapping("/all")
    public List<Tecnico> getAllTecnico(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public Tecnico getTecnicoById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addTecnico(@RequestBody Tecnico newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateTecnico(@RequestBody Tecnico record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteTecnico(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

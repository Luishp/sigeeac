/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Archivo;
import com.app.sigeeac.model.Caracteristica;
import com.app.sigeeac.service.ArchivoService;
import com.app.sigeeac.service.CaracteristicaService;
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
@RequestMapping("/caracteristica")
public class CaracteristicaRest {
    @Autowired
    private CaracteristicaService myService;
    
    @RequestMapping("/all")
    public List<Caracteristica> getAllCaracteristica(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public Caracteristica getCaracteristicaById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addCaracteristica(@RequestBody Caracteristica newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateCaracteristica(@RequestBody Caracteristica record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteCaracteristica(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.Bitacora;
import com.app.sigeeac.service.BitacoraService;
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
@RequestMapping("/bitacora")
public class BitacoraRest {
    @Autowired
    private BitacoraService myService;
    
    @RequestMapping("/all")
    public List<Bitacora> getAllBitacoras(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public Bitacora getBitacoraById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addBitacora(@RequestBody Bitacora newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateBitacora(@RequestBody Bitacora registro, @PathVariable("id") String id){
        myService.save(registro);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteBitacora(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

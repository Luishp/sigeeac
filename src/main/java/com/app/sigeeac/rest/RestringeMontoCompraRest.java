/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.RestringeMontoCompra;
import com.app.sigeeac.service.RestringeMontoCompraService;
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
@RequestMapping("/restringe")
public class RestringeMontoCompraRest {
    @Autowired
    private RestringeMontoCompraService myService;
    
    @RequestMapping("/all")
    public List<RestringeMontoCompra> getAllRestringeMontoCompra(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public RestringeMontoCompra getRestringeMontoCompraById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addRestringeMontoCompra(@RequestBody RestringeMontoCompra newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateRestringeMontoCompra(@RequestBody RestringeMontoCompra record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteRestringeMontoCompra(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

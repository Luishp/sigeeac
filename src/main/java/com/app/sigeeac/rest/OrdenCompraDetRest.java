/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.OrdenCompraDet;
import com.app.sigeeac.service.OrdenCompraDetService;
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
@RequestMapping("/ordenCompraDet")
public class OrdenCompraDetRest {
    @Autowired
    private OrdenCompraDetService myService;
    
    @RequestMapping("/all")
    public List<OrdenCompraDet> getAllOrdenCompraDet(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public OrdenCompraDet getOrdenCompraDetById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addOrdenCompraDet(@RequestBody OrdenCompraDet newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateCaracteristica(@RequestBody OrdenCompraDet record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteOrdenCompraDet(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

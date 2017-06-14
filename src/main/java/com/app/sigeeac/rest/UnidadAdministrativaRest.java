/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.UnidadAdministrativa;
import com.app.sigeeac.service.UnidadAdministrativaService;
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
@RequestMapping("/unidadAdministrativa")
public class UnidadAdministrativaRest {
    @Autowired
    private UnidadAdministrativaService myService;
    
    @RequestMapping("/all")
    public List<UnidadAdministrativa> getAllUnidadAdministrativa(){
        return myService.findAll();
    }
    @RequestMapping("/getById/{id}")
    public UnidadAdministrativa getUnidadAdministrativaById(@PathVariable("id") String id){
        return myService.findOne(Integer.parseInt(id));
    }
    @RequestMapping(method=RequestMethod.POST, value="/save")
    public void addUnidadAdministrativa(@RequestBody UnidadAdministrativa newRecord){
        myService.save(newRecord);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateUnidadAdministrativa(@RequestBody UnidadAdministrativa record, @PathVariable("id") String id){
        myService.save(record);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteUnidadAdministrativa(@PathVariable("id") String id){
        myService.delete(Integer.parseInt(id));
    }
}

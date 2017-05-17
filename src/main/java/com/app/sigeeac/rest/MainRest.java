/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.rest;

import com.app.sigeeac.model.InstitucionGubernamental;
import com.app.sigeeac.service.InstitucionGubernamentalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luish
 */
@RestController
public class MainRest {
    
    @RequestMapping("/")
    public String index() {
        return "Bienvenido usuario de Spring!!!";
    }
    
    @RequestMapping("/user")
    public String getUser() {
        return "Bienvenido Luis";
    }
}

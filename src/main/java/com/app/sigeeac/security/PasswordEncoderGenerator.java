/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sigeeac.security;

import com.app.sigeeac.util.Sha1Generator;

/**
 *
 * @author luish
 */
public class PasswordEncoderGenerator {

    public String encode(CharSequence password) {
        return Sha1Generator.generar(password.toString());
    }

    public boolean matches(CharSequence password, String userInput) {
        return (password != null && Sha1Generator.generar(password.toString()).equals(userInput));
    }
}

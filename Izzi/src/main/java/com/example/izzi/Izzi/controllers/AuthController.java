package com.example.izzi.Izzi.controllers;

import com.example.izzi.Izzi.models.usuarioModel;
import com.example.izzi.Izzi.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.izzi.Izzi.dao.userDao;

@RestController
public class AuthController {

    @Autowired
    private userDao userDao;
    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/login", method = RequestMethod.GET)
    public String loginUser(@RequestBody usuarioModel user){

        usuarioModel userLogin = userDao.getUser(user);
        if (userLogin != null){

            String token = jwtUtil.create(String.valueOf(userLogin.getId()), userLogin.getCorreo());
            return (token);
        }else {
            return ("401");
        }
    }


}
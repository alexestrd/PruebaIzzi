package com.example.izzi.Izzi.controllers;

import com.example.izzi.Izzi.models.usuarioModel;
import com.example.izzi.Izzi.utils.JWTUtil;
import com.example.izzi.Izzi.dao.userDao;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private userDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/register", method = RequestMethod.POST)
    public ResponseEntity<String> postUser(@Valid @RequestBody usuarioModel user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024, 1, user.getContraseña());
        user.setContraseña(hash);
        userDao.postUser(user);
        return new  ResponseEntity<>("creado", HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.PUT)
    public usuarioModel editUser(@RequestBody usuarioModel user, @PathVariable Long id){
        user = new usuarioModel();
        userDao.editUser(user, id);
        return user;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<usuarioModel> getUsers(@RequestHeader (value = "Autorization") String token){

        String userID = jwtUtil.getKey(token);
        if (userID == null){
            return new ArrayList<>();
        }
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userDao.deleteUser(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.NO_CONTENT);
    }
}

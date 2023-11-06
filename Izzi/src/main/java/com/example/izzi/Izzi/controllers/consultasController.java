package com.example.izzi.Izzi.controllers;

import com.example.izzi.Izzi.dao.consultasDao;
import com.example.izzi.Izzi.models.consultasModel;
import com.example.izzi.Izzi.models.usuarioModel;
import com.example.izzi.Izzi.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class consultasController {

    @Autowired
    private consultasDao ConsultasDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/consulta", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> postUser(@Valid @RequestBody consultasModel consulta, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", bindingResult.getFieldError().getDefaultMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        String respuesta =  ConsultasDao.postConsulta(consulta);
        if ("Creado".equals(respuesta)) {
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("message", respuesta);
            successResponse.put("consulta", consulta);
            return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Error al registrar la consulta");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "api/consulta/{id}", method = RequestMethod.PUT)
    public consultasModel editUser(@RequestBody consultasModel consulta, @PathVariable Long id){
        consulta = new consultasModel();
        ConsultasDao.editConsulta(consulta, id);
        return consulta;
    }

    @RequestMapping(value = "api/consultas", method = RequestMethod.GET)
    public List<consultasModel> getUsers(){


        return ConsultasDao.getConsultas();
    }

    @RequestMapping(value = "api/consulta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        ConsultasDao.deleteConsulta(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.NO_CONTENT);
    }
}

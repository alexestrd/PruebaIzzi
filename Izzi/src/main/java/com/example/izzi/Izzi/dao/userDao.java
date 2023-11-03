package com.example.izzi.Izzi.dao;

import com.example.izzi.Izzi.models.usuarioModel;

import java.util.List;

public interface userDao {

    void editUser(usuarioModel user, Long id);

    void deleteUser(Long id);

    void postUser(usuarioModel user);

    usuarioModel getUser(usuarioModel user);

    List<usuarioModel> getUsers();
}

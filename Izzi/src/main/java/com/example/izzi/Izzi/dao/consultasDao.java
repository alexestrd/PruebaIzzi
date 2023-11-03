package com.example.izzi.Izzi.dao;

import com.example.izzi.Izzi.models.consultasModel;
import com.example.izzi.Izzi.models.usuarioModel;

import java.io.IOException;
import java.util.List;

public interface consultasDao {
    void editConsulta(consultasModel consulta, Long id);

    void deleteConsulta(Long id);

    void postConsulta(consultasModel consulta) throws IOException;

    List<consultasModel> getConsulta(Long id);

    List<consultasModel> getConsultas();
}

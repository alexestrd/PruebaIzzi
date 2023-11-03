package com.example.izzi.Izzi.dao;

import com.example.izzi.Izzi.models.consultasModel;
import com.example.izzi.Izzi.models.usuarioModel;
import com.example.izzi.Izzi.services.IpGeo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Repository
@Transactional
public class consultasDaoImp implements consultasDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IpGeo ipgeo;

    @Override
    public void editConsulta(consultasModel consulta, Long id) {
        consultasModel searchConsulta = entityManager.find(consultasModel.class, id);
        searchConsulta = consulta;
        entityManager.merge(searchConsulta);
    }

    @Override
    public void deleteConsulta(Long id) {
        usuarioModel consulta =  entityManager.find(usuarioModel.class, id);
        entityManager.remove(consulta);
    }

    @Override
    public void postConsulta(consultasModel consulta) throws IOException {
        String ip = consulta.getIp();
        IpGeo ipGeo = new IpGeo(ip);
        //entityManager.merge(consulta);
    }

    @Override
    public List<consultasModel> getConsulta(Long id) {
        String idconverter = Long.toString(id);
        String query = "FROM consultasModel WHERE id =:id";
        List<consultasModel> consulta = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        return consulta;
    }

    @Override
    public List<consultasModel> getConsultas() {
        String query = "FROM consultasModel";
        return entityManager.createQuery(query).getResultList();
    }
}

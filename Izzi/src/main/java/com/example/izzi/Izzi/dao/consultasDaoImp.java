package com.example.izzi.Izzi.dao;

import com.example.izzi.Izzi.models.consultasModel;
import com.example.izzi.Izzi.models.dataipModel;
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
    private IpGeo ipGeo;

    @Override
    public void editConsulta(consultasModel consulta, Long id) {
        consultasModel searchConsulta = entityManager.find(consultasModel.class, id);
        searchConsulta = consulta;
        entityManager.merge(searchConsulta);
    }

    @Override
    public void deleteConsulta(Long id) {
        consultasModel consulta =  entityManager.find(consultasModel.class, id);
        entityManager.remove(consulta);
    }

    @Override
    public String postConsulta(consultasModel consulta) throws IOException {
        String ip = consulta.getIp();
        String nombre = consulta.getNombre();
        String query = "FROM consultasModel WHERE ip = :ip";
        List<consultasModel> list = entityManager.createQuery(query)
                .setParameter("ip", ip)
                .getResultList();

        if (!list.isEmpty()){
           for (consultasModel item : list){
               if(item.getIp().equals(ip) && item.getNombre().equals(nombre)){
                   return "Existe";
               }else {
                   dataipModel geoData = ipGeo.getInfo(ip);
                   int cp = Integer.parseInt(geoData.getPostcode());
                   String ciudad = geoData.getCity().getName();
                   String pais = geoData.getCountry().getName();
                   String estado = geoData.getArea().getName();
                   String idioma = geoData.getCountry().getLanguages().getEs();
                   String moneda = geoData.getCurrency().getName();
                   String continente  = geoData.getContinent().getName();
                   String longitud = String.valueOf(geoData.getLocation().getLongitude());
                   String latitud = String.valueOf(geoData.getLocation().getLatitude());

                   consulta.setCp(cp);
                   consulta.setCiudad(ciudad);
                   consulta.setPais(pais);
                   consulta.setEstado(estado);
                   consulta.setIdioma(idioma);
                   consulta.setMoneda(moneda);
                   consulta.setContinente(continente);
                   consulta.setLongitud(longitud);
                   consulta.setLatitud(latitud);
                   entityManager.merge(consulta);
                   return "Creado";
               }
           }
        }
            dataipModel geoData = ipGeo.getInfo(ip);
        System.out.println(geoData);
            int cp = Integer.parseInt(geoData.getPostcode());
            String ciudad = geoData.getCity().getName();
            String pais = geoData.getCountry().getName();
            String estado = geoData.getArea().getName();
            String idioma = geoData.getCountry().getLanguages().getEs();
            String moneda = geoData.getCurrency().getName();
            String continente = geoData.getContinent().getName();
            String longitud = String.valueOf(geoData.getLocation().getLongitude());
            String latitud = String.valueOf(geoData.getLocation().getLatitude());

            consulta.setCp(cp);
            consulta.setCiudad(ciudad);
            consulta.setPais(pais);
            consulta.setEstado(estado);
            consulta.setIdioma(idioma);
            consulta.setMoneda(moneda);
            consulta.setContinente(continente);
            consulta.setLongitud(longitud);
            consulta.setLatitud(latitud);
            entityManager.merge(consulta);
            return "Creado";

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

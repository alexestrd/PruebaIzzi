package com.example.izzi.Izzi.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import com.example.izzi.Izzi.models.usuarioModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class userDaoImp implements userDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void editUser(usuarioModel user, Long id) {
    usuarioModel searchUser = entityManager.find(usuarioModel.class, id);
    searchUser = user;
    entityManager.merge(searchUser);
    }

    @Override
    public void deleteUser(Long id) {
    usuarioModel user =  entityManager.find(usuarioModel.class, id);
    entityManager.remove(user);
    }

    @Override
    public void postUser(usuarioModel user) {
       entityManager.merge(user);
    }

    public usuarioModel getUser(usuarioModel user) {
        String query = "FROM usuarioModel WHERE correo = :correo";
        List<usuarioModel> list = entityManager.createQuery(query)
                .setParameter("correo", user.getCorreo())
                .getResultList();

        if(list.isEmpty()){
            return null;
        }

        String passwordHashed = list.get(0).getContraseña();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, user.getContraseña())){
            return list.get(0);
        }
        return null;
    }


    @Override
    public List<usuarioModel> getUsers() {
        String query = "FROM usuarioModel";
        return entityManager.createQuery(query).getResultList();
    }





}

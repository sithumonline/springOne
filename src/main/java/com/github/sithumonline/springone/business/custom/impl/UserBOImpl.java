package com.github.sithumonline.springone.business.custom.impl;

import com.github.sithumonline.springone.business.custom.UserBO;
import com.github.sithumonline.springone.entity.Users;
import com.github.sithumonline.springone.repository.RepositoryFactory;
import com.github.sithumonline.springone.repository.custom.UserRepository;
import com.github.sithumonline.springone.resources.HibernateUtil;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class UserBOImpl implements UserBO {

    private UserRepository userRepository;

    public UserBOImpl() {
        userRepository = (UserRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.USER);
    }

    @Override
    public boolean addUser(Users userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);

            Users user = new Users(
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getFullname(),
                    userDTO.getEmail()
            );

            boolean result = userRepository.save(user);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateUser(Users userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);

            Users user = new Users(
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getFullname(),
                    userDTO.getEmail()
            );

            userRepository.update(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteUser(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);
            Users user = userRepository.findById(userId);
            if (user != null){
                userRepository.delete(user);
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public Users getUserById(String userId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);
            Users user = userRepository.findById(userId);
            session.getTransaction().commit();
            if (user != null){
                return new Users(
                        user.getUsername(),
                        user.getPassword(),
                        user.getFullname(),
                        user.getEmail()
                );
            }else {
                return null;
            }
        }
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            userRepository.setSession(session);
            List<Users> userList = userRepository.findAll();
            session.getTransaction().commit();

            return userList;
        }
    }
}

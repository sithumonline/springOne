package com.github.sithumonline.springone.business.custom;

import com.github.sithumonline.springone.business.SuperBO;
import com.github.sithumonline.springone.entity.Users;

import java.util.List;
//import javafx.collections.ObservableList;


public interface UserBO extends SuperBO{

    boolean addUser(Users userDTO)throws Exception;

    boolean updateUser(Users userDTO)throws Exception;

    boolean deleteUser(String userId)throws Exception;

    Users getUserById(String userId)throws Exception;

  List<Users> getAllUsers()throws Exception;

//    ObservableList<Users> getAllUsers()throws Exception;
}

package com.github.sithumonline.springone.controller;

import com.github.sithumonline.springone.business.BOFactory;
import com.github.sithumonline.springone.business.custom.UserBO;
import com.github.sithumonline.springone.entity.Users;
//import javafx.collections.ObservableList;

import java.util.List;

public class UserController {

    public static boolean addUser(Users userDTO)throws Exception{
        UserBO userService = (UserBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.addUser(userDTO);
    }

    public static boolean updateUser(Users userDTO)throws Exception{
        UserBO userService = (UserBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.updateUser(userDTO);
    }

    public static boolean deleteUser(String userId)throws Exception{
        UserBO userService = (UserBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.deleteUser(userId);
    }

    public static List<Users> getUserList()throws Exception{
        UserBO userService = (UserBO)  BOFactory.getInstance().getBOFactory(BOFactory.BOTypes.USER);
        return userService.getAllUsers();
    }
    
}

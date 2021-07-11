package com.github.sithumonline.springone;

import com.github.sithumonline.springone.controller.UserController;
import com.github.sithumonline.springone.entity.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserHandler {

    @PostMapping("/users")
    public String save(@RequestBody Users users) throws Exception {
        UserController.addUser(users);
        return "success";
    }

    @GetMapping("/users")
    public List<Users> getALlPersons() throws Exception {
        return UserController.getUserList();
    }

}

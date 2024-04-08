package com.hyungu.whoseturn.controller;

import com.hyungu.whoseturn.model.UserModel;
import com.hyungu.whoseturn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserModel addMember(@RequestBody UserModel userModel) {
        System.out.println("run PostMapping ++++++++++++");
        return userService.saveMember(userModel);
    }

    @GetMapping
    public List<UserModel> getAllMembers() {
        System.out.println("run PostMapping ++++++++++++");
        return userService.getAllMembers();
    }

    @GetMapping("/{id}")
    public UserModel getMemberById(@PathVariable Long id) {
        return userService.getMemberById(id);
    }

    @PutMapping("/{id}")
    public UserModel updateMember(@RequestBody UserModel userModel, @PathVariable Long id) {
        return userService.updateMember(userModel, id);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        userService.deleteMember(id);
        return "UserModel deleted successfully";
    }

}

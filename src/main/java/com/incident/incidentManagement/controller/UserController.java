package com.incident.incidentManagement.controller;

import com.incident.incidentManagement.dtos.UserDto;
import com.incident.incidentManagement.entity.User;
import com.incident.incidentManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping(value = "/create-user")
    public void createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUser(@PathVariable String userName, @RequestBody UserDto updatedUser) {
        User user = userService.updateUser(userName, updatedUser);
        return ResponseEntity.ok(user);
    }


}

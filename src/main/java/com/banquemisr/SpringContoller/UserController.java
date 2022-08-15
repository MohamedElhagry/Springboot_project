package com.banquemisr.SpringContoller;


import com.banquemisr.DTOs.UserDTO;
import com.banquemisr.Service.UserService;
import com.banquemisr.persistence.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/create")
    public User createNewUser(@RequestBody UserDTO userDTO)
    {
        User user = new User();
        modelMapper.map(userDTO, user);
        return userService.createNewUser(user);
    }

}

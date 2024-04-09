package com.example.java_be_template.controllers;

import com.example.java_be_template.interfaces.CreateUserDto;
import com.example.java_be_template.interfaces.UserDto;
import com.example.java_be_template.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/get-users")
    public List<UserDto> getUsers() throws Exception {
        try {
            return this.usersService.getUsers();
        } catch (Exception err) {
            System.out.println(err);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("failed to get users"),
                    err
            );
        }
    }

    @GetMapping("/get-users-page")
    public List<UserDto> getUsersPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) throws Exception {
        try {
            return this.usersService.getUsersPageable(pageNumber, pageSize);
        } catch (Exception err) {
            System.out.println(err);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("failed to get users page"),
                    err
            );
        }
    }

    @GetMapping("/get-user-by-name")
    public UserDto getUserByName(@RequestParam String name) throws Exception {
        try {
            return this.usersService.getUserByName(name);
        } catch (Exception err) {
            System.out.println(err);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("failed to get user by name"),
                    err
            );
        }
    }

    @PostMapping("/create-new-user")
    public UserDto createNewUser(@RequestBody CreateUserDto createUserDto) throws Exception {
        try {
            return this.usersService.createNewUser(createUserDto);
        } catch (Exception err) {
            System.out.println(err);
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    String.format("failed to create new user"),
                    err
            );
        }
    }
}

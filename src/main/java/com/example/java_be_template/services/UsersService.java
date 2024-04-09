package com.example.java_be_template.services;

import com.example.java_be_template.entities.User;
import com.example.java_be_template.interfaces.CreateUserDto;
import com.example.java_be_template.interfaces.UserDto;
import com.example.java_be_template.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    public UserRepository usersRepository;

    public UsersService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDto convertUserToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName()
        );
    }

    public List<UserDto> getUsers() {
        return this.usersRepository.findAll().stream().map(this::convertUserToDto).toList();
    }

    public List<UserDto> getUsersPageable(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "name");
        return this.usersRepository.findAll(pageRequest).stream().map(this::convertUserToDto).toList();
    }

    public UserDto createNewUser(CreateUserDto createUserDto) {
        User newUser = new User(createUserDto.name);
        User savedUser = this.usersRepository.save(newUser);
        return this.convertUserToDto(savedUser);
    }

    public UserDto getUserByName(String name) {
        List<User> users = this.usersRepository.getByCustomName(name);
        return this.convertUserToDto(users.get(0));
    }
}

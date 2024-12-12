package com.dyPham.examSpringboot.service;

import com.dyPham.examSpringboot.dto.UserDTO;
import com.dyPham.examSpringboot.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<UserDTO> findAll();

    Optional<Users> findById(Long id);

    Users save(Users t);

    void remove(Long id);

    List<Users> searchUser(String search);
}

package com.dyPham.examSpringboot.service.impl;

import com.dyPham.examSpringboot.dto.UserDTO;
import com.dyPham.examSpringboot.entities.Users;
import com.dyPham.examSpringboot.repository.UserRepository;
import com.dyPham.examSpringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<UserDTO> findAll() {
        List<Users> list = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (Users users : list) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setName(users.getName());
            userDTO.setAge(users.getAge());
            userDTO.setSalary(users.getSalary());
            dtoList.add(userDTO);
        }
        return dtoList;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users save(Users t) {
        return userRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
    public List<Users> searchUser(String search){
        return userRepository.findAllByNameContaining(search);
    }
}

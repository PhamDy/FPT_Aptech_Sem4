package com.dyPham.examSpringboot.controller;

import com.dyPham.examSpringboot.dto.ResponseObject;
import com.dyPham.examSpringboot.dto.UserDTO;
import com.dyPham.examSpringboot.entities.Users;
import com.dyPham.examSpringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseObject> getAll(){
        Iterable<UserDTO> list = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("true", "ok", list)
        );
    }

    @PostMapping
    public ResponseEntity<ResponseObject> insertUser(@Valid @RequestBody Users model){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("true", "ok", userService.save(model))
        );
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        Optional<Users> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        modelMapper.map(user, userOptional.get());
        return new ResponseEntity<>( userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteCategory(@PathVariable Long id) {
        Optional<Users> userOptional = userService.findById(id);
        return userOptional.map(category -> {
            userService.remove(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public List<Users> search(String search){
        return userService.searchUser(search);
    }



}

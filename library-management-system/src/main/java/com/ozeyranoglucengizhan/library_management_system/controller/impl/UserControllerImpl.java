package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IUserController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;
import com.ozeyranoglucengizhan.library_management_system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/library")
@RequiredArgsConstructor
public class UserControllerImpl implements IUserController {

    private final IUserService userService;

    @PostMapping(path = "/createUser")
    @Override
    public ResponseEntity<Void> createUser(@RequestBody DtoUsers dtoUser) {
        userService.createUser(dtoUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/updateUser/{id}")
    @Override
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody DtoUsers dtoUser) {
        userService.updateUser(id,dtoUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/getUserById/{id}")
    @Override
    public ResponseEntity<DtoUsers> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(path = "/getUserList")
    @Override
    public ResponseEntity<List<DtoUsers>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }
}

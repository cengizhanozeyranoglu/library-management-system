package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    ResponseEntity<Void> createUser(DtoUsers dtoUser);

    ResponseEntity<Void> deleteUser(Long id);

    ResponseEntity<Void> updateUser(Long id, DtoUsers dtoUser);

    ResponseEntity<DtoUsers> getUserById(Long id);

    ResponseEntity<List<DtoUsers>> getUserList();
}

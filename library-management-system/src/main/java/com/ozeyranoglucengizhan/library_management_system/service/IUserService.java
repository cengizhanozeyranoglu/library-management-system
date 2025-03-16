package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;

import java.util.List;

public interface IUserService {

    void createUser(DtoUsers dtoUser);

    boolean deleteUser(Long id);

    void updateUser(Long id, DtoUsers dtoUser);

    DtoUsers getUserById(Long id);

    List<DtoUsers> getUserList();


}

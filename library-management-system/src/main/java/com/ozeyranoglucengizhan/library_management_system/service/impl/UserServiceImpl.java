package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;
import com.ozeyranoglucengizhan.library_management_system.entity.Users;
import com.ozeyranoglucengizhan.library_management_system.mapper.UserMapper;
import com.ozeyranoglucengizhan.library_management_system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    @Override
    public boolean createUser(DtoUsers dtoUser) {
        Users user = UserMapper.INSTANCE.toEntity(dtoUser);
        return true;
    }
}

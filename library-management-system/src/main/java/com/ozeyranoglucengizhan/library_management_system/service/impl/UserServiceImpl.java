package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;
import com.ozeyranoglucengizhan.library_management_system.entity.Users;
import com.ozeyranoglucengizhan.library_management_system.mapper.UserMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.UsersRepository;
import com.ozeyranoglucengizhan.library_management_system.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UsersRepository userRepository;

    @Override
    public void createUser(DtoUsers dtoUser) {
        Users user = UserMapper.INSTANCE.toEntity(dtoUser);
        userRepository.save(user);
        log.info("User created id:" + user.getId());
    }

    @Override
    public boolean deleteUser(Long id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userRepository.delete(user);
        log.info("User deleted id:" + id);
        return true;
    }

    @Override
    public void updateUser(Long id, DtoUsers dtoUser) {
        Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        UserMapper.INSTANCE.updateUser(dtoUser, user);
        log.info("User updated id:" + id);
        userRepository.save(user);
    }

    @Override
    public DtoUsers getUserById(Long id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        DtoUsers dtoUser = UserMapper.INSTANCE.toDto(user);
        return dtoUser;
    }

    @Override
    public List<DtoUsers> getUserList() {
        List<Users> userList = userRepository.findAll();
        List<DtoUsers> dtoUserList = UserMapper.INSTANCE.toDtoUserList(userList);
        return dtoUserList;
    }
}

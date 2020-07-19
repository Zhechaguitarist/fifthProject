package com.fifthProject.fifthProject.service;

import com.fifthProject.fifthProject.entity.User;

import java.util.List;

public interface UserService {

    Long create(User user);

    List<User> read();

    boolean update(User user);

    boolean delete(Long id);
}

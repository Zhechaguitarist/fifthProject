package com.fifthProject.fifthProject.repository;

import com.fifthProject.fifthProject.entity.User;

import java.util.List;

public interface UserRepository {

    Long create(User user);

    List<User> read();

    boolean update(User user);

    boolean delete(Long id);
}

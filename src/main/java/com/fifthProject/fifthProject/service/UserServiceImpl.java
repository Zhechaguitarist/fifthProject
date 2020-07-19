package com.fifthProject.fifthProject.service;

import com.fifthProject.fifthProject.entity.User;
import com.fifthProject.fifthProject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public Long create(User user) {
        return userRepository.create(user);
    }

    @Override
    public List<User> read() {
        return userRepository.read();
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean delete(Long id) {
        return userRepository.delete(id);
    }
}

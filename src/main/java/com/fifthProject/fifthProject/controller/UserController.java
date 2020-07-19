package com.fifthProject.fifthProject.controller;

import com.fifthProject.fifthProject.entity.User;
import com.fifthProject.fifthProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping("create")
    public Long create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("list/read")
    public List<User> readAll() {
        return userService.read();
    }

    @PutMapping("update")
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }


    @GetMapping
    public String hello() {
        OffsetDateTime currentTime = OffsetDateTime.now();
        String day = String.format("%02d", currentTime.getDayOfMonth());
        String month = String.format("%02d", currentTime.getMonthValue());
        int year = currentTime.getYear();
        return "HELLO! Today is " + day + "." + month + "." + year;
    }
}

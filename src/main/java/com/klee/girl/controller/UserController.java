package com.klee.girl.controller;


import com.klee.girl.domain.Result;
import com.klee.girl.domain.User;
import com.klee.girl.repository.GirlRepository;
import com.klee.girl.repository.UserRepository;
import com.klee.girl.service.UserService;
import com.klee.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public Result findUser(User user) {

        return ResultUtil.success(userService.findUser(user.getId()));

    }

}

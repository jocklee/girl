package com.klee.girl.service;

import com.klee.girl.domain.User;
import com.klee.girl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.OpenOption;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);
    }
}

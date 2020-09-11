package com.example.demo.repo;

import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepoTest {

    private static final String MAIL = "ayd@mail.ru";
    private static final String USERNAME = "ayd";


    @Autowired
    UserRepo userRepo;

    @BeforeEach
    @Transactional
    @Rollback(false)
    public void setUp() {
        userRepo.save(new User(USERNAME, MAIL, "123"));
    }

    @Test
    @Transactional
    void existsByUsername() {
        Assert.assertTrue(userRepo.existsByUsername(USERNAME));
    }

    @Test
    void existsByEmail() {
        Assert.assertTrue(userRepo.existsByEmail(MAIL));
    }
}
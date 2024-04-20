package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    void loginByUser1() {
        String user1 = "user1";
        String result = userService.loginByUserName(user1);
        assertEquals(user1,result);
    }
    @Test
    void loginByUser2() {
        String user2 = "user2";
        String result = userService.loginByUserName(user2);
        assertEquals(user2,result);
    }
    @Test
    void loginByUser3() {
        String user3 = "user3";
        String result = userService.loginByUserName(user3);
        assertEquals(user3,result);
    }
}
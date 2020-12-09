package net.xdclass.forum.service;

import net.xdclass.forum.domain.User;

import java.util.List;

public interface UserService {

    int register(User user);

    User login(String phone,String pwd);

    List<User> list();
}

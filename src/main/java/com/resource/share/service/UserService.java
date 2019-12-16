package com.resource.share.service;


import com.resource.share.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUser();
    User queryUserByToken(String token);
    User queryUserByIsAdmin(Integer isAdmin);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int userId);
}

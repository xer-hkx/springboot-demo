package com.resource.share.service;


import com.resource.share.entity.User;


public interface UserService {
    User queryUser(User user);
    User queryUserByToken(String token);
    User queryUserByIsAdmin(Integer isAdmin);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int userId);
}

package com.resource.share.dao;

import com.resource.share.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser();
    User queryUserByToken(String token);
    User queryUserByIsAdmin(Integer isAdmin);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int userId);

}

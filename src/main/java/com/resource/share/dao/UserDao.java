package com.resource.share.dao;

import com.resource.share.entity.User;

public interface UserDao {
    User queryUser(User user);
    User queryUserByToken(String token);
    User queryUserByIsAdmin(Integer isAdmin);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int userId);

}

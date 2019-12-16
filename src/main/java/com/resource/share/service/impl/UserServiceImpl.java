package com.resource.share.service.impl;

import com.resource.share.dao.UserDao;
import com.resource.share.entity.User;
import com.resource.share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }

    @Override
    public User queryUserByToken(String token) {
        return userDao.queryUserByToken(token);
    }

    @Override
    public User queryUserByIsAdmin(Integer isAdmin) {
        return userDao.queryUserByIsAdmin(isAdmin);
    }

    @Transactional
    @Override
    public boolean insertUser(User user) {
        if(user.getUserName() != null && !"".equals(user.getUserName()) && user.getPassword() != null){
        //if(user.getUserName() == null){
            try{
                int effectedNum = userDao.insertUser(user);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("注册失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("注册失败：" + e.getMessage());
            }
        }else{
            throw new RuntimeException("账号或密码不能为空！");
        }
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getUserId() != null && user.getUserId() > 0) {
            try {
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("账号信息更改失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更改失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("账号信息不能为空！");
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userId > 0) {
            try {
                int effectedNum = userDao.deleteUser(userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("账号删除失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("账号id不能为空！");
        }
    }
}

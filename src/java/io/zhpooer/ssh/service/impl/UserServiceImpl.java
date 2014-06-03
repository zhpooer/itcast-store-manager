package io.zhpooer.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import io.zhpooer.ssh.dao.UserDao;
import io.zhpooer.ssh.domain.User;
import io.zhpooer.ssh.service.UserService;

public class UserServiceImpl implements UserService {
    @Resource(name="userDao")
    private UserDao userDao;
    
    @Override
    @Transactional(readOnly=true)
    public User login(String username) {
        return userDao.findByName(username);
    }

}

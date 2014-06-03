package io.zhpooer.ssh.dao;

import io.zhpooer.ssh.domain.User;

public interface UserDao {

    User findByName(String username);
    
}

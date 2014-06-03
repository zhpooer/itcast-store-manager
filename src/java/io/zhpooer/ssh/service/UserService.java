package io.zhpooer.ssh.service;

import io.zhpooer.ssh.domain.User;

public interface UserService {
    public User login(String username);
}

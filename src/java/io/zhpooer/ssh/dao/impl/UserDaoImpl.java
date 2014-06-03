package io.zhpooer.ssh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;

import io.zhpooer.ssh.dao.UserDao;
import io.zhpooer.ssh.domain.User;

public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("hibernateTemplate")
    private HibernateTemplate template;

    @Override
    public User findByName(String username) {
        @SuppressWarnings("unchecked")
        List<User> users = template.find("from User where username=?",
                username);
        return users.isEmpty() ? null : users.get(0);
    }

}

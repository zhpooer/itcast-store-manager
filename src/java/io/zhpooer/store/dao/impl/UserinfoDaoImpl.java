package io.zhpooer.store.dao.impl;

import io.zhpooer.store.dao.UserinfoDao;
import io.zhpooer.store.domain.Userinfo;
import io.zhpooer.store.tools.MD5Utils;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserinfoDaoImpl implements UserinfoDao {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate template;

    @PostConstruct
    public void setUp() {
        Userinfo uinfo = new Userinfo();
        uinfo.setName("poe");
        uinfo.setPassword(MD5Utils.md5("123"));
        template.save(uinfo);
    }

    @Override
    public Userinfo login(Userinfo user) {
        @SuppressWarnings("unchecked")
        List<Userinfo> users = template.findByNamedQuery("Userinfo.login",
                user.getName(), MD5Utils.md5(user.getPassword()));
        return users.isEmpty() ? null : users.get(0);
    }

}

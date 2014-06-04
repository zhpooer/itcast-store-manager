package io.zhpooer.store.service.impl;

import io.zhpooer.store.dao.UserinfoDao;
import io.zhpooer.store.domain.Userinfo;
import io.zhpooer.store.service.UserinfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
public class UserinfoServiceImpl implements UserinfoService{
    
    @Autowired
    @Qualifier("userinfoDao")
    private UserinfoDao userinfoDao;
    
    @Override
    @Transactional(readOnly=true)
    public Userinfo login(Userinfo user) {
        return userinfoDao.login(user);
    }

}

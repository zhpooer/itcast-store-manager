package io.zhpooer.store.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import io.zhpooer.store.dao.HistoryDao;
import io.zhpooer.store.domain.History;

public class HistoryDaoImpl implements HistoryDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate template;
    @Override
    public void save(History history) {
        template.save(history);
    }

}

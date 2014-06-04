package io.zhpooer.store.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import io.zhpooer.store.dao.StoreDao;
import io.zhpooer.store.domain.Store;

public class StoreDaoImpl implements StoreDao {
    @Resource(name="hibernateTemplate")
    private HibernateTemplate template;
    
    @PostConstruct
    public void setUp() {
        Store store = new Store();
        store.setName("海贼王");
        store.setAddress("北京一号线");
        store.setManager("女娲");
        template.save(store);
    }

    
    @Override
    public void add(Store store) {
        template.save(store);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Store> findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Store.class);
        return template.findByCriteria(detachedCriteria);
    }

    @Override
    public void update(Store store) {
        template.update(store);
    }

    @Override
    public Store findById(int id) {
        return template.get(Store.class, id); 
    }

    @Override
    public void delete(Store store) {
        template.delete(store);
    }
    
}

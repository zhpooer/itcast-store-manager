package io.zhpooer.store.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import io.zhpooer.store.dao.StoreDao;
import io.zhpooer.store.domain.Store;
import io.zhpooer.store.service.StoreService;

public class StoreSerivceImpl implements StoreService {
    @Resource(name="storeDao")
    private StoreDao storeDao;
    
    @Transactional
    @Override
    public void addStore(Store store) {
        storeDao.add(store);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Store> findAllService() {
        return storeDao.findAll();

    }

    @Override
    @Transactional
    public void updateStore(Store store) {
        storeDao.update(store);
    }

    @Override
    @Transactional(readOnly=true)
    public Store findStoreById(int id) {
        return storeDao.findById(id);
    }

    @Override
    public void delStore(Store store) {
        storeDao.delete(store);
    }

}

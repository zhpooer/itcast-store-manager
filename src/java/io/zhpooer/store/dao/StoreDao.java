package io.zhpooer.store.dao;

import java.util.List;

import io.zhpooer.store.domain.Store;

public interface StoreDao {
    public void add(Store store);

    public List<Store> findAll();

    public void update(Store store);

    public Store findById(int id);

    public void delete(Store store);
}

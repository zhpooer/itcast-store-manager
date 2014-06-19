package io.zhpooer.store.service;

import java.util.List;

import io.zhpooer.store.domain.Store;

public interface StoreService {
    public void addStore(Store store);

    public List<Store> findAllStore();

    public void updateStore(Store store);

    public Store findStoreById(int id);

    public void delStore(Store store);
}

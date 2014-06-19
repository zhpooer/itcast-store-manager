package io.zhpooer.store.service;

import java.util.List;

import io.zhpooer.store.bean.Pagination;
import io.zhpooer.store.domain.Goods;
import io.zhpooer.store.domain.Userinfo;

public interface GoodsService {

    Goods findByNm(String nm);

    void saveGoods(Goods goods, Userinfo user);

    List<Goods> findNameLike(String name);

    void findPageData(Pagination pagination);
    
}

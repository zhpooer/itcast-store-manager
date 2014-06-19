package io.zhpooer.store.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import io.zhpooer.store.domain.Goods;

public interface GoodsDao {
    Goods findByNm(String nm);

    void save(Goods goods);

    Goods findById(String id);

    List<Goods> findNameLike(String name);

    List<Goods> findPageData(DetachedCriteria detachedCriteria,
            int firstResult, int maxResults);

    long findTotalCount(DetachedCriteria detachedCriteria);
}

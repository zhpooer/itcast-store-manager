package io.zhpooer.store.dao.impl;

import io.zhpooer.store.dao.GoodsDao;
import io.zhpooer.store.domain.Goods;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class GoodsDaoImpl implements GoodsDao {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate template;

    @Override
    public Goods findByNm(String nm) {
        @SuppressWarnings("unchecked")
        List<Goods> goods = template.find("from Goods where nm like ?", "%"
                + nm + "%");
        return goods.isEmpty() ? null : goods.get(0);
    }

    @Override
    public void save(Goods goods) {
        template.save(goods);
    }

    @Override
    public Goods findById(String id) {
        @SuppressWarnings("unchecked")
        List<Goods> goods = template.find("from Goods where id=?", id);
        return goods.isEmpty() ? null : goods.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Goods> findNameLike(String name) {
        String hql = "from Goods where name like ?";
        return template.find(hql, "%" + name + "%");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Goods> findPageData(DetachedCriteria detachedCriteria,
            int firstResult, int maxResults) {
        return template.findByCriteria(detachedCriteria, firstResult, maxResults);
    }

    @Override
    public long findTotalCount(DetachedCriteria detachedCriteria) {
        return (Long) template.findByCriteria(detachedCriteria).get(0);
    }

}

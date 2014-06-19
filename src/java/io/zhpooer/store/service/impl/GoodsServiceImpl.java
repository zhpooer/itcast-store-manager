package io.zhpooer.store.service.impl;

import io.zhpooer.store.bean.Pagination;
import io.zhpooer.store.dao.GoodsDao;
import io.zhpooer.store.dao.HistoryDao;
import io.zhpooer.store.domain.Goods;
import io.zhpooer.store.domain.History;
import io.zhpooer.store.domain.Store;
import io.zhpooer.store.domain.Userinfo;
import io.zhpooer.store.service.GoodsService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class GoodsServiceImpl implements GoodsService {

    @Resource(name = "goodsDao")
    private GoodsDao goodsDao;
    @Resource(name = "historyDao")
    private HistoryDao historyDao;

    @Override
    public Goods findByNm(String nm) {
        return goodsDao.findByNm(nm);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void saveGoods(Goods goods, Userinfo user) {
        // 判断页面是否传递货物 id
        // 如果goods 里id不为空, 说明货物已经存在, 只需要修改数量
        if (StringUtils.isNotBlank(goods.getId())) {
            // 修改数量----update
            Goods persistGoods = goodsDao.findById(goods.getId());
            persistGoods
                    .setAmount(persistGoods.getAmount() + goods.getAmount());
            History history = new History();
            history.setUser(user.getName());
            history.setType("1");
            history.setDatetime(new Date().toLocaleString());
            history.setGoods(persistGoods);
            history.setAmount(goods.getAmount());
            history.setRemain(persistGoods.getAmount());// 余量
            historyDao.save(history);
        } else {
            // 新货物入库
            goodsDao.save(goods);

            History history = new History();
            history.setUser(user.getName());
            history.setType("1");
            history.setDatetime(new Date().toLocaleString());
            history.setGoods(goods);
            history.setAmount(goods.getAmount());
            history.setRemain(goods.getAmount());// 余量
            historyDao.save(history);
        }
    }

    @Override
    public List<Goods> findNameLike(String name) {
        return goodsDao.findNameLike(name);
    }

    @Override
    public void findPageData(Pagination pagination) {
        // 分页查询代码
        Map<String, String[]> parameterMap = pagination.getParameterMap(); // 所有查询条件
        // 转换条件为QBC对象
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(Goods.class); // select * from goods ;
        // QBC 单表条件
        if (StringUtils.isNotBlank(getValueFromMap(parameterMap, "nm"))) {
            // 根据简记码查询
            detachedCriteria.add(Restrictions.eq("nm",
                    getValueFromMap(parameterMap, "nm"))); // nm =?
        }
        if (StringUtils.isNotBlank(getValueFromMap(parameterMap, "name"))) {
            // 根据货物名称查询
            detachedCriteria.add(Restrictions.like("name", "%"
                    + getValueFromMap(parameterMap, "name") + "%")); // name
                                                                     // like ?
        }
        if (StringUtils.isNotBlank(getValueFromMap(parameterMap, "store.id"))) {
            Store store = new Store();
            store.setId(Integer.parseInt(getValueFromMap(parameterMap, "store.id")));// 脱管对象
            detachedCriteria.add(Restrictions.eq("store", store)); // 当比较对象时，自动比较对象的id
                                                                   // storeid=?
        }
        // 调用DAO层，根据当前条件，查询记录总数 --- 投影 select * 变为 select count(*)
        detachedCriteria.setProjection(Projections.rowCount()); // 投影
        long totalCount = goodsDao.findTotalCount(detachedCriteria);
        pagination.setTotalCount(totalCount);

        // 总页数，可以计算 (总记录数/每页记录数 ,如果有余数+1页)
        int totalPageCount = (int) ((totalCount + pagination.getNumberPerPage() - 1) / pagination
                .getNumberPerPage());
        pagination.setTotalPageCount(totalPageCount);

        // 分页查询代码
        // 计算 firstResult maxResults
        int firstResult = (pagination.getPageno() - 1)
                * pagination.getNumberPerPage();
        int maxResults = pagination.getNumberPerPage();

        // 操作清除投影效果 select count(*) ---- select *
        detachedCriteria.setProjection(null);

        List<Goods> goodses = goodsDao.findPageData(detachedCriteria,
                firstResult, maxResults);
        pagination.setData(goodses);
    }

    // 工具方法
    public String getValueFromMap(Map<String, String[]> parameterMap, String key) {
        String[] values = parameterMap.get(key);
        return values == null ? null : values[0];
    }
}

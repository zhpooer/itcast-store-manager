package io.zhpooer.store.web.action;

import io.zhpooer.store.bean.Pagination;
import io.zhpooer.store.domain.Goods;
import io.zhpooer.store.domain.Userinfo;
import io.zhpooer.store.service.GoodsService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class GoodsAction extends ActionSupport implements ModelDriven<Goods> {
    private Goods goods = new Goods();
    @Resource(name = "goodsService")
    private GoodsService goodsService;

    @Override
    public Goods getModel() {
        return goods;
    }

    public String findByNm() {
        Goods queryGoods = goodsService.findByNm(goods.getNm());
        ActionContext.getContext().getValueStack().push(queryGoods);
        return "findByNmSuccess";
    }

    public String save() {
        Userinfo user = (Userinfo) ActionContext.getContext().getSession()
                .get("user");
        goodsService.saveGoods(goods, user);
        return "saveSccess"; // remain.jsp
    }

    public String findNameLike() {
        List<Goods> goodies = goodsService.findNameLike(goods.getName());
        ActionContext.getContext().getValueStack().push(goodies);
        return "findNameLikeSuccess";
    }

    @SuppressWarnings("unchecked")
    public String pageQuery() {
        Pagination pagination = new Pagination();
        HttpServletRequest req = ServletActionContext.getRequest();
        if (req.getParameter("pageno") == null) {
            pagination.setPageno(1);
        } else {
            pagination.setPageno(Integer.parseInt(req.getParameter("pageno")));
        }
        pagination.setParameterMap(req.getParameterMap());
        goodsService.findPageData(pagination);
        return "pageQuerySuccess";
    }
}

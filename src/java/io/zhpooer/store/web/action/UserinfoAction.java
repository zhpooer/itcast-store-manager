package io.zhpooer.store.web.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import io.zhpooer.store.domain.Userinfo;
import io.zhpooer.store.service.UserinfoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UserinfoAction extends ActionSupport implements
        ModelDriven<Userinfo> {
    private final Logger LOG = Logger.getLogger(Userinfo.class);
    private Userinfo userinfo = new Userinfo();

    @Resource(name = "userinfoService")
    private UserinfoService userinfoService;

    @Override
    public Userinfo getModel() {
        return userinfo;
    }

    public String login() {
        Userinfo loginUser = userinfoService.login(userinfo);
        if (loginUser == null) {
            addActionError("用户名不存在或密码错误");
            return INPUT;
        } else {
            LOG.info(userinfo + "登陆");
            ActionContext.getContext().getSession().put("user", loginUser);
            return SUCCESS;
        }
    }
    
}

package io.zhpooer.store.web.interceptor;

import io.zhpooer.store.domain.Userinfo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        Userinfo user = (Userinfo) invocation.getInvocationContext()
                .getSession().get("user");
        if (user == null) {
            return "login";
        } else {
            return invocation.invoke();
        }
    }

}

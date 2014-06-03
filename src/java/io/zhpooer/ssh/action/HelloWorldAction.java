package io.zhpooer.ssh.action;

import io.zhpooer.ssh.domain.User;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String sayHello() {
        System.out.println("good morning, " + user.getUsername());
        return NONE;
    }

}

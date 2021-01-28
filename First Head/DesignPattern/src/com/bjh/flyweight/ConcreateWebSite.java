package com.bjh.flyweight;

public class ConcreateWebSite extends WebSite {
    private String type = "";

    public ConcreateWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站以" + type +"的形式发布了,使用者：" + user.getName());
    }
}

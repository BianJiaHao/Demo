package com.bjh.flyweight;

import com.bjh.composite.University;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSite1 = factory.getWebSiteCategory("博客");
        webSite1.use(new User("Tom"));

        WebSite webSite2 = factory.getWebSiteCategory("网络");
        webSite2.use(new User("JackLove"));

        WebSite webSite3 = factory.getWebSiteCategory("网络");
        webSite3.use(new User("Obito"));

        int count = factory.getWebSiteCount();

        System.out.println(count);


    }
}

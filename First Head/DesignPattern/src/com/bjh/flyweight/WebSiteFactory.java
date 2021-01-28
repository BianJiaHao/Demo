package com.bjh.flyweight;

import java.util.HashMap;

public class WebSiteFactory {
    private HashMap<String,ConcreateWebSite> pool = new HashMap<>();

    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreateWebSite(type));
        }
        return (WebSite)pool.get(type);
    }

    public int getWebSiteCount(){
        return pool.size();
    }
}

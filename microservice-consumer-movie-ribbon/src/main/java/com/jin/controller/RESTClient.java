package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RESTClient {
    @Autowired
    private RestTemplate template;

    private final static String url = "http://localhost:8080/SpringRestWS/restful/";

    public String show() {
        return template.getForObject(url + "show.do", String.class, new String[]{});
    }

    public String getUserById(String id) {
        return template.getForObject(url + "get/{id}.do", String.class, id);
    }

    public String addUser(String user) {
        return template.postForObject(url + "add.do?user={user}", null, String.class, user);
    }

    public String editUser(String user) {
        template.put(url + "edit.do?user={user}", null, user);
        return user;
    }

    public String removeUser(String id) {
        template.delete(url + "/remove/{id}.do", id);
        return id;
    }
}

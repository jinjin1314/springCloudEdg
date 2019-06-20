package com.jin.controller;


import com.jin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MoveController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @RequestMapping("user/{id}")
    public String findById(@PathVariable int id) {
        return this.restTemplate.getForObject(userServiceUrl+"getUser/" + id, String.class, new String[]{});
    }

    @RequestMapping("testPort")
    public String testPort() {
        return this.restTemplate.getForObject(userServiceUrl+"port", String.class);
    }
}

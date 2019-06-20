package com.jin.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class RESTController {
    @RequestMapping(value = "/show", method = RequestMethod.GET)

    public ModelAndView show() {
        System.out.println("show");
        ModelAndView model = new ModelAndView("xStreamMarshallingView");
        model.addObject("show method");
        return model;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable String id) {
        System.out.println("getUserById-" + id);
        ModelAndView model = new ModelAndView("xStreamMarshallingView");
        model.addObject("getUserById method -" + id);
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(String user) {
        System.out.println("addUser-" + user);
        ModelAndView model = new ModelAndView("xStreamMarshallingView");
        model.addObject("addUser method -" + user);
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ModelAndView editUser(String user) {
        System.out.println("editUser-" + user);
        ModelAndView model = new ModelAndView("xStreamMarshallingView");
        model.addObject("editUser method -" + user);
        return model;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ModelAndView removeUser(@PathVariable String id) {
        System.out.println("removeUser-" + id);
        ModelAndView model = new ModelAndView("xStreamMarshallingView");
        model.addObject("removeUser method -" + id);
        return model;
    }
}

package org.yz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 张鹏程 on 2017/6/22.
 */
@RestController
public class BaseController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView response = new ModelAndView("login");
        return response;
    }

    @RequestMapping(value = "/login/password", method = RequestMethod.GET)
    public ModelAndView loginDefault() {
        ModelAndView loginView = new ModelAndView("login_password");
        return loginView;
    }

    @RequestMapping(value = "/login/wx", method = RequestMethod.GET)
    public ModelAndView loginWX() {
        ModelAndView loginView = new ModelAndView("login_wx");
        return loginView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView registerView = new ModelAndView("register");
        return registerView;
    }
}

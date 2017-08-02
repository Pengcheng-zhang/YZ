package org.yz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.yz.domain.Account;

import javax.servlet.http.HttpSession;


/**
 * Created by 张鹏程 on 2017/6/22.
 */
@RestController
public class HomeController{

    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView homeView = new ModelAndView("home");

        Account account = (Account) httpSession.getAttribute("yz_user_info");
        if (account != null) {
            homeView.addObject("user", account);
        }
        return homeView;
    }
}

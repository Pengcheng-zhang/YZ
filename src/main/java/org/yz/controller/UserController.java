package org.yz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.yz.domain.Account;
import org.yz.service.AccountService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by 张鹏程 on 2017/6/8.
 */
@RestController
public class UserController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/private",method = RequestMethod.GET)
    public String index() {
        return "hello private";
    }

    @RequestMapping(value = "/public")
    public String index2() {
        return "hello public!";
    }
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public Account getUserById(@RequestParam(value = "id", required = true) Long id) {
        return accountService.getUserById(id).orElse(null);
    }
}

package org.yz.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yz.dao.Message;
import org.yz.domain.Account;
import org.yz.service.AccountService;
import org.yz.service.OauthService;

import javax.servlet.http.HttpSession;

/**
 * Created by 张鹏程 on 2017/6/19.
 */
@RestController
public class OauthController {

    @Autowired
    OauthService oauthService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "oauth/token", method = RequestMethod.POST)
    public Message token(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {

        Message message =  oauthService.getTokenByNameAndPassword(username, password);
        if (message.getCode() == "10000") {
            Account account = accountService.findByName(username);
            httpSession.setAttribute("yz_user_info", account);
        }
        return message;
    }

    @RequestMapping(value = "oauth/register", method = RequestMethod.POST )
    public Message register(@RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password,
                            @RequestParam(value = "confirm_password", required = true) String confirm_password) {
        Message message = oauthService.register(username, password, confirm_password);
        if (message.getCode() == "10000") {
            Account account = accountService.findByName(username);
            httpSession.setAttribute("yz_user_info", account);
        }
        return message;
    }
}

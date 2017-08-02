package org.yz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 张鹏程 on 2017/6/7.
 */
@Controller
public class ErrorController {
    @RequestMapping("/400")
    public String badRequest() {
        return "error/400";
    }

    @RequestMapping("/404")
    public String notFound() {
        return "error/404";
    }

    @RequestMapping("/500")
    public String serverError() {
        return "error/500";
    }
}

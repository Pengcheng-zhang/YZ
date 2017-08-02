package org.yz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张鹏程 on 2017/6/7.
 */
@RestController
public class TestController {

    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/test/{id}")
    public String test2(@PathVariable Integer id) {
        return "test2:" + id;
    }
}

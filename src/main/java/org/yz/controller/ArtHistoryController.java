package org.yz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yz.dao.Message;
import org.yz.service.ArtService;

/**
 * Created by 张鹏程 on 2017/6/8.
 */
@RestController
public class ArtHistoryController {

    @Autowired
    ArtService artService;
}

package org.yz.controller;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yz.dao.Message;
import org.yz.domain.Account;
import org.yz.domain.ArtListOut;
import org.yz.domain.art.Art;
import org.yz.service.ArtService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by 张鹏程 on 2017/6/8.
 */
@RestController
public class ArtController {

    @Autowired
    private ArtService artService;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "art/list", method = RequestMethod.POST)
    public Map<String, Object> getArtList(@RequestParam(value = "page", required = false) Integer page,
                                          @RequestParam(value = "limit", required = false) Integer limit) {
       List<ArtListOut> out =  artService.getArtList(page, limit);
       Map<String, Object> map = new HashMap<>();
       map.put("code", "10000");
       map.put("message", "success");
        Map<String, Object> list_map = new HashMap<>();
        list_map.put("list", out);
        map.put("result", list_map);
       return map;
    }

    @RequestMapping(value = "art/create", method = RequestMethod.POST)
    public Message create(Art art) {
        Account account = (Account) httpSession.getAttribute("yz_user_info");
        art.setUserId(account.getId());
        Message message = artService.create(art);
        return message;
    }

    @RequestMapping(value = "art/detail/{id}", method = RequestMethod.GET)
    public Map<String, Object> detail(@PathVariable Long id) {
        ArtListOut artListOut = artService.detail(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "10000");
        map.put("message", "success");
        map.put("result", artListOut);
        return map;
    }

    @RequestMapping(value = "art/prise/{artId}", method = RequestMethod.POST)
    public Message prise(@PathVariable Long id) {
        Account account = (Account) httpSession.getAttribute("yz_user_info");
        Message message = artService.prise(account.getId(), id);
        return message;
    }

    @RequestMapping(value = "art/comment", method = RequestMethod.POST)
    public Message comment(@RequestParam(value = "page", required = true) Long id) {
        Account account = (Account) httpSession.getAttribute("yz_user_info");
        Message message = artService.comment(account.getId(),id);
        return message;
    }

    @RequestMapping(value = "art/punish/{artId}", method = RequestMethod.POST)
    public Message punish(@PathVariable Long id) {
        Account account = (Account) httpSession.getAttribute("yz_user_info");
        Message message = artService.punish(account.getId(),id);
        return message;
    }

    @RequestMapping(value = "user/level", method = RequestMethod.GET)
    public Map<String, BigInteger> levels(@RequestParam(value = "uid", required = true) Long user_id) {
        Map<String, BigDecimal> ret_map = artService.getPriseAndPunishTotal(user_id);
        Map<String, BigInteger> map = new HashMap<>();
        for(Map.Entry<String, BigDecimal> entry : ret_map.entrySet()){
            BigInteger value = entry.getValue().toBigInteger();
            map.put(entry.getKey(), value);
        }
        return map;
    }
}

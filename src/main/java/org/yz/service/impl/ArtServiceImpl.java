package org.yz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yz.dao.Message;
import org.yz.dao.art.ArtDao;
import org.yz.dao.art.ArtHistoryDao;
import org.yz.domain.ArtListOut;
import org.yz.domain.art.Art;
import org.yz.domain.art.ArtHistory;
import org.yz.service.ArtService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鹏程 on 2017/6/26.
 * error code range: 20001 ~ 29999
 */
@Service
public class ArtServiceImpl implements ArtService {

    @Autowired
    private ArtDao artDao;

    @Autowired
    private ArtHistoryDao artHistoryDao;

    public Message message;

    public ArtServiceImpl(){
        message = new Message("10000", "success", "");
    }

    private boolean check_data(Art art) {
        if (art.getTitle() == "") {
            message.setCode("20005");
            message.setMessage("文章标题不能为空！");
        }

        if (art.getTitle().length() > 100) {
            message.setCode("20006");
            message.setMessage("标题长度不能超过100个字符！");
        }

        if (art.getContent() == "") {
            message.setCode("20007");
            message.setMessage("文章内容不能为空！");
        }

        if (art.getContent().length() > 500) {
            message.setCode("20008");
            message.setMessage("文章内容不能超过500字符");
        }

        if (art.getImgUrl().split(";").length > 6) {
            message.setCode("20009");
            message.setMessage("最多添加6张图片");
        }

        if (message.getCode() != "10000") {
            return false;
        }
        return true;
    }
    private boolean check_exist(Long id) {
        ArtListOut artListOut =artDao.getArtById(id);
        if (artListOut == null) {
            message.setCode("20008");
            message.setMessage("该文章不存在！");
            return false;
        }
        return true;
    }

    public List<ArtListOut> getArtList(Integer page, Integer limit) {
        if (page <= 0) {
            page = 1;
        }

        if (limit <= 0) {
            limit = 10;
        }
        return artDao.getList(page, limit);
    }

    public ArtListOut detail(Long id) {
        ArtListOut artListOut= artDao.getArtById(id);
        artDao.addViewCount(id);
        return artListOut;
    }

    public Message create(Art art) {
        boolean ret = check_data(art);
        if (ret) {
            Long id = artDao.create(art);
            message.setResult(id.toString());
        }
        return message;
    }

    public Message deleteById(Long id) {
        artDao.deleteById(id);
        return message;
    }

    public Message update(Art art) {
        boolean ret = check_data(art);
        if (ret) {
            Long id = artDao.update(art);
            message.setResult(id.toString());
        }

        return message;
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    public Message prise(Long user_id, Long id) {
        if ( check_exist(id) ) {
            ArtHistory artHistory = artHistoryDao.getPrisedOrPunished(user_id, id);
            if (artHistory != null) {
                //如果有过赞，再点一次即取消
                if (artHistory.getType() == 0) {
                    artHistoryDao.updateType(artHistory.getId(), -1);
                    artDao.cancelPrise(id);
                }else if (artHistory.getType() == 1) {
                    //原来是鄙视的，现在点赞
                    artHistoryDao.updateType(artHistory.getId(), 0);
                    artDao.cancelPunishAndPrise(id);
                }else{
                    artHistoryDao.updateType(artHistory.getId(), 0);
                    Long num = artDao.prise(id);
                    message.setResult(num.toString());
                }
            }else{
                artHistory.setUserd(user_id);
                artHistory.setArtId(id);
                artHistory.setType(0);
                artHistoryDao.create(artHistory);
                Long num = artDao.prise(id);
                message.setResult(num.toString());
            }
        }
        return message;
    }

    /**
     * 评论数增加
     * @param id
     * @return
     */
    public Message comment(Long user_id, Long id) {
        if (check_exist(id)) {
            Long num = artDao.comment(id);
            message.setResult(num.toString());
        }
        return message;
    }

    /**
     * 鄙视数增加
     * @param id
     * @return
     */
    public Message punish(Long user_id, Long id){
        if (check_exist(id)) {
            ArtHistory artHistory = artHistoryDao.getPrisedOrPunished(user_id, id);
            if (artHistory != null) {
                //如果有过鄙视，再点一次即取消
                if (artHistory.getType() == 1) {
                    artHistoryDao.updateType(artHistory.getId(), -1);
                    artDao.cancelPunish(id);
                } else if (artHistory.getType() == 0) {
                    //原来是点赞的，现在鄙视
                    artHistoryDao.updateType(artHistory.getId(), 1);
                    artDao.cancelPriseAndPunish(id);
                } else {
                    //原来是取消的
                    artHistoryDao.updateType(artHistory.getId(), 1);
                    Long num = artDao.punish(id);
                    message.setResult(num.toString());
                }
            } else {
                artHistory.setUserd(user_id);
                artHistory.setArtId(id);
                artHistory.setType(1);
                artHistoryDao.create(artHistory);
                Long num = artDao.punish(id);
                message.setResult(num.toString());
            }
        }
        return message;
    }

    public Map<String, BigDecimal> getPriseAndPunishTotal(Long user_id) {
        return artDao.getPriseAndPunishTotal(user_id);
    }
}

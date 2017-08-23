package org.yz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.yz.dao.Message;
import org.yz.dao.art.ArtCommentsDao;
import org.yz.dao.art.ArtCommentsHistoryDao;
import org.yz.domain.art.ArtComments;
import org.yz.domain.art.ArtCommentsHistory;
import org.yz.service.ArtCommentService;
import org.yz.service.ArtService;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/7/6.
 */
public class ArtCommentServiceImpl implements ArtCommentService {

    private Message message;

    @Autowired
    private ArtCommentsDao artCommentsDao;

    @Autowired
    private ArtService artService;

    @Autowired
    private ArtCommentsHistoryDao artCommentsHistoryDao;

    public ArtCommentServiceImpl() {
        message = new Message("10000", "success", "");
    }

    private boolean check_exist(Long id) {
        ArtComments artComments =artCommentsDao.getById(id);
        if (artComments == null) {
            message.setCode("20008");
            message.setMessage("该评论不存在！");
            return false;
        }
        return true;
    }

    public List<ArtComments> getListByArtId(Long artId, Integer page, Integer limit) {
        if (page <= 0) {
            page = 1;
        }

        if (limit <= 0) {
            limit = 10;
        }
        Long offset = new Long((page - 1) * limit);
        return artCommentsDao.getByArtId(artId, page, offset);
    }

    public Message create(Long user_id, Long art_id, String comment) {
        if (comment.trim().isEmpty()) {
            message.setCode("30001");
            message.setResult("评论内容不能为空！");
            return message;
        }
        boolean exist = artService.check_exist(art_id);
        if ( ! exist) {
            message.setCode("20008");
            message.setMessage("文章不存在！");
        }else {
            ArtComments artComments = new ArtComments();
            artComments.setUserId(user_id);
            artComments.setArtId(art_id);
            artComments.setComments(comment);
            Long id = artCommentsDao.create(artComments);
            message.setResult(id.toString());
        }
        return message;
    }

    public Message deleteById(Long id) {
        artCommentsDao.delete(id);
        return message;
    }

    public Message prise(Long user_id, Long id) {
        if ( check_exist(id) ) {
            ArtCommentsHistory artCommentsHistory = artCommentsHistoryDao.getPrisedOrPunished(user_id, id);
            if (artCommentsHistory != null) {
                //如果对该评论有过点赞，再点一次取消
                if(artCommentsHistory.getType() == 1) {
                    artCommentsHistoryDao.updateType(id, 0);
                    artCommentsDao.cancelPrise(id);
                }else if(artCommentsHistory.getType() == 2) {
                    //原来是鄙视的，再点一次是取消鄙视
                    artCommentsHistoryDao.updateType(id, 0);
                    artCommentsDao.cancelPunish(id);
                }else{
                    artCommentsHistoryDao.updateType(id, 1);
                    artCommentsDao.prise(id);
                }
            }else{
                artCommentsHistory.setUserId(user_id);
                artCommentsHistory.setType(1);
                artCommentsHistory.setCommentId(id);
                artCommentsHistoryDao.create(artCommentsHistory);
                Long num = artCommentsDao.prise(id);
                message.setResult(num.toString());
            }
        }
        return message;
    }

    public Message punish(Long user_id, Long id) {
        artCommentsDao.punish(id);
        return message;
    }
}

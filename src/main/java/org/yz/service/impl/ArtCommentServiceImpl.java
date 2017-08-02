package org.yz.service.impl;

import org.yz.dao.Message;
import org.yz.domain.art.ArtComments;
import org.yz.service.ArtCommentService;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/7/6.
 */
public class ArtCommentServiceImpl implements ArtCommentService {

    private Message message;

    public List<ArtComments> getArtList(Integer page, Integer limit) {

    }
    public Message create(Long artId, ArtComments artComments) {
        return message;
    }
    public Message deleteById(Long id) {
        return message;
    }
    public Message prise(Long user_id, Long id) {
        return message;
    }
    public Message punish(Long user_id, Long id) {
        return message;
    }
}

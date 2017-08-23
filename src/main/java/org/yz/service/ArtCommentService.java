package org.yz.service;

import org.yz.dao.Message;
import org.yz.domain.art.ArtComments;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/7/6.
 */
public interface ArtCommentService {
    List<ArtComments> getListByArtId(Long artId, Integer page, Integer limit);
    Message create(Long user_id, Long art_id, String comment);
    Message deleteById(Long id);
    Message prise(Long user_id, Long id);
    Message punish(Long user_id, Long id);
}

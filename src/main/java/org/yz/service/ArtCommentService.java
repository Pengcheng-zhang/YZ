package org.yz.service;

import org.yz.dao.Message;
import org.yz.domain.art.ArtComments;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/7/6.
 */
public interface ArtCommentService {
    List<ArtComments> getArtList(Integer page, Integer limit);
    Message create(Long artId, ArtComments artComments);
    Message deleteById(Long id);
    Message prise(Long user_id, Long id);
    Message punish(Long user_id, Long id);
}

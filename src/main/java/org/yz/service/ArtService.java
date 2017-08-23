package org.yz.service;

import org.yz.dao.Message;
import org.yz.domain.ArtListOut;
import org.yz.domain.art.Art;
import org.yz.domain.art.ArtHistory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鹏程 on 2017/6/26.
 */
public interface ArtService {
    List<ArtListOut> getArtList(Integer page, Integer limit);
    boolean check_exist(Long id);
    ArtListOut detail(Long id);
    Message create(Art art);
    Message update(Art art);
    Message deleteById(Long id);
    Message prise(Long user_id, Long id);
    Message comments(Long user_id, Long id);
    Message punish(Long user_id, Long id);
    Map<String, BigDecimal> getPriseAndPunishTotal(Long user_id);
}

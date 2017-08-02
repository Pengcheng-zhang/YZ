package org.yz.dao.art;

import org.springframework.stereotype.Repository;
import org.yz.domain.ArtListOut;
import org.yz.domain.art.Art;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鹏程 on 2017/6/26.
 */
@Repository
public interface ArtDao {
    ArtListOut getArtById(Long id);
    List<ArtListOut> getList(Integer page, Integer limit);
    Long create(Art art);
    Long deleteById(Long id);
    Long update(Art art);
    Long prise(Long id);
    Long comment(Long id);
    Long punish(Long id);
    Long cancelPrise(Long id);
    Long cancelPunish(Long id);
    Long cancelPriseAndPunish(Long id);
    Long cancelPunishAndPrise(Long id);
    Long addViewCount(Long id);
    Map<String, BigDecimal> getPriseAndPunishTotal(Long user_id);
}

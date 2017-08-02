package org.yz.dao.art;

import org.springframework.stereotype.Repository;
import org.yz.domain.art.ArtHistory;

/**
 * Created by 张鹏程 on 2017/6/26.
 */
@Repository
public interface ArtHistoryDao {
    Long create(ArtHistory artHistory);
    Long cancel(Long user_id, Long art_id);
    ArtHistory getPrisedOrPunished(Long user_id, Long art_id);
    Long updateType(Long id, Integer type);
}

package org.yz.dao.art;

import org.springframework.stereotype.Repository;
import org.yz.domain.art.ArtCommentsHistory;

/**
 * Created by 张鹏程 on 2017/8/7.
 */
@Repository
public interface ArtCommentsHistoryDao {
    Long create(ArtCommentsHistory artHistory);
    Long cancel(Long user_id, Long art_id);
    ArtCommentsHistory getPrisedOrPunished(Long user_id, Long art_id);
    Long updateType(Long id, Integer type);
}

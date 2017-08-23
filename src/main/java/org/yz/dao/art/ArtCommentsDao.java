package org.yz.dao.art;

import org.springframework.stereotype.Repository;
import org.yz.domain.art.ArtComments;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/6/26.
 */
@Repository
public interface ArtCommentsDao {
    List<ArtComments> getByArtId(Long artId, Integer page, Long offset);
    ArtComments getById(Long id);
    Long create(ArtComments artComments);
    Long delete(Long id);
    Long update(Long id);
    Long prise(Long id);
    Long punish(Long id);
    Long cancelPrise(Long id);
    Long cancelPunish(Long id);
}

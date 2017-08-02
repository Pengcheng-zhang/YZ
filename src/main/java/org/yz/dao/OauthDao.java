package org.yz.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by 张鹏程 on 2017/6/19.
 */
@Repository
public interface OauthDao {
    String getAccessTokenByNameAndPassword(String username, String password);
    String generateAccessTokenByNameAndPassword(String username, String password);
    String refreshAccessToken();
    Integer saveAccessToken(Long user_id, String access_token);
}

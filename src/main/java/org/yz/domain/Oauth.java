package org.yz.domain;

/**
 * Created by 张鹏程 on 2017/6/19.
 */
public class Oauth {

    private String access_token;
    private Long user_id;
    private Long id;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

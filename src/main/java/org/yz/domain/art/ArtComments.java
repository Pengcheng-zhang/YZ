package org.yz.domain.art;

/**
 * Created by 张鹏程 on 2017/6/26.
 * 图文评论表
 */
public class ArtComments {

    private Long id;
    private Long userId;  //用户id
    private Long artId; //文章id
    private String comments; //评论
    private Long pId; //上级评论id
    private Integer priseNum; //点赞数
    private Integer punishNum; //鄙视数
    private String createdAt; //评论时间


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Integer getPriseNum() {
        return priseNum;
    }

    public void setPriseNum(Integer priseNum) {
        this.priseNum = priseNum;
    }

    public Integer getPunishNum() {
        return punishNum;
    }

    public void setPunishNum(Integer punishNum) {
        this.punishNum = punishNum;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

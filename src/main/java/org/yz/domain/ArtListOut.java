package org.yz.domain;

/**
 * Created by 张鹏程 on 2017/6/27.
 */
public class ArtListOut {
    private Long id; //文章id
    private Integer userId;  //用户id
    private String author; //作者
    private String title; //标题
    private String content; //内容
    private String imgUrl; //关联图片
    private Integer priseCount; //文章被赞数
    private Integer punishCount; //文章鄙视数
    private Integer commCount; //评论数
    private Integer viewCount; //浏览次数
    private String createdAt; //创建时间
    private String updatedAt; //更新时间

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPriseCount() {
        return priseCount;
    }

    public void setPriseCount(Integer priseCount) {
        this.priseCount = priseCount;
    }

    public Integer getPunishCount() {
        return punishCount;
    }

    public void setPunishCount(Integer punishCount) {
        this.punishCount = punishCount;
    }

    public Integer getCommCount() {
        return commCount;
    }

    public void setCommCount(Integer commCount) {
        this.commCount = commCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}

package org.yz.domain.art;

/**
 * Created by 张鹏程 on 2017/6/26.
 */
public class ArtHistory {
    private Long id;
    private Long artId;
    private Long userd;
    private Integer type;
    private String updatedAt;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public Long getUserd() {
        return userd;
    }

    public void setUserd(Long userd) {
        this.userd = userd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

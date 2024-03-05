package com.example.vidvibebackend.Entity;

import lombok.*;


import javax.persistence.*;
import java.util.Set;

/**
 * @author Zhenliang Yu
 */
// 标签(Tag)实体
@Entity
@Table(name = "Tags")
@Getter
@Setter

public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(nullable = false, unique = true, length = 100)
    private String tagName;

    // 多对多关系 - 标签与视频（通过中间表VideoTags）
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "VideoTags",
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    @ToString.Exclude
    private Set<Video> videos;

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", videos=" + videos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tag tag = (Tag) o;

        if (!tagId.equals(tag.tagId)) {
            return false;
        }
        if (!tagName.equals(tag.tagName)) {
            return false;
        }
        return videos.equals(tag.videos);
    }

    @Override
    public int hashCode() {
        int result = tagId.hashCode();
        result = 31 * result + tagName.hashCode();
        result = 31 * result + videos.hashCode();
        return result;
    }
}
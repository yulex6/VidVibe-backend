package com.example.vidvibebackend.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Zhenliang Yu
 */
// 视频(Video)实体
@Entity
@Table(name = "Videos")
@Getter
@Setter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    @Column(nullable = false)
    private String title;

    @Lob
    private String description;

    private Integer duration; // 假设以秒为单位

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;

    private Long viewsCount;

    private Long likesCount;

    private Long collectsCount;
    private Long commentsCount;

    // 多对多关系 - 视频与标签（通过中间表VideoTags）
    @ManyToMany(mappedBy = "videos", cascade = CascadeType.ALL)
    private Set<Tag> tags;

    public Video() {
    }

    public Video(Integer videoId, String title, String description, Integer duration, Date uploadTime, Long viewsCount, Long likesCount, Long collectsCount, Long commentsCount, Set<Tag> tags) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.uploadTime = uploadTime;
        this.viewsCount = viewsCount;
        this.likesCount = likesCount;
        this.collectsCount = collectsCount;
        this.commentsCount = commentsCount;
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Video video = (Video) o;
        return Objects.equals(videoId, video.videoId) && Objects.equals(title, video.title) && Objects.equals(description, video.description) && Objects.equals(duration, video.duration) && Objects.equals(uploadTime, video.uploadTime) && Objects.equals(viewsCount, video.viewsCount) && Objects.equals(likesCount, video.likesCount) && Objects.equals(collectsCount, video.collectsCount) && Objects.equals(commentsCount, video.commentsCount) && Objects.equals(tags, video.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, title, description, duration, uploadTime, viewsCount, likesCount, collectsCount, commentsCount, tags);
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", uploadTime=" + uploadTime +
                ", viewsCount=" + viewsCount +
                ", likesCount=" + likesCount +
                ", collectsCount=" + collectsCount +
                ", commentsCount=" + commentsCount +
                ", tags=" + tags +
                '}';
    }
}

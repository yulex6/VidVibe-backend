package com.example.vidvibebackend.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Zhenliang Yu
 */
// 用户行为(UserBehavior)实体
@Entity
@Table(name = "UserBehavior")
@Getter
@Setter

public class UserBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer behaviorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private ActionType actionType; // 自定义枚举类型

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;


    public enum ActionType {
        VIEW,
        LIKE,
        SHARE,
        COMMENT,
        COLLECT,
    }

    public UserBehavior() {
    }

    @Override
    public String toString() {
        return "UserBehavior{" +
                "behaviorId=" + behaviorId +
                ", user=" + user +
                ", video=" + video +
                ", actionType=" + actionType +
                ", timestamp=" + timestamp +
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
        UserBehavior that = (UserBehavior) o;
        return Objects.equals(behaviorId, that.behaviorId) && Objects.equals(user, that.user) && Objects.equals(video, that.video) && actionType == that.actionType && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(behaviorId, user, video, actionType, timestamp);
    }
}
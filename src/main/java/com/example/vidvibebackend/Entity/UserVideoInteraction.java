package com.example.vidvibebackend.Entity;

import lombok.*;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Zhenliang Yu
 */
// 用户-视频交互评分(UserVideoInteraction)实体
@Entity
@Table(name = "UserVideoInteraction")
@Getter
@Setter

public class UserVideoInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column()
    private Integer interactionScore;


    public UserVideoInteraction() {
    }

    @Override
    public String toString() {
        return "UserVideoInteraction{" +
                "id=" + id +
                ", user=" + user +
                ", video=" + video +
                ", interactionScore=" + interactionScore +
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
        UserVideoInteraction that = (UserVideoInteraction) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(video, that.video) && Objects.equals(interactionScore, that.interactionScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, video, interactionScore);
    }
}
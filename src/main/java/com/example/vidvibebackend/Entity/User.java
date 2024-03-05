package com.example.vidvibebackend.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

// 用户(User)实体
@Entity
@Table(name = "Users")
@Getter
@Setter

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 255)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String profileInfo;

    @Column(columnDefinition = "TEXT")
    private String preferences;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // 一对多关系 - 用户行为集合
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserBehavior> behaviors;

    // 多对多关系 - 关注者与被关注者（双向）
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Following",
        joinColumns = @JoinColumn(name = "follower_id"),
        inverseJoinColumns = @JoinColumn(name = "followed_id")
    )
    private Set<User> following;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", profileInfo='" + profileInfo + '\'' +
                ", preferences='" + preferences + '\'' +
                ", createdAt=" + createdAt +
                ", behaviors=" + behaviors +
                ", following=" + following +
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

        User user = (User) o;

        if (!Objects.equals(userId, user.userId)) {
            return false;
        }
        if (!Objects.equals(username, user.username)) {
            return false;
        }
        if (!Objects.equals(profileInfo, user.profileInfo)) {
            return false;
        }
        if (!Objects.equals(preferences, user.preferences)) {
            return false;
        }
        if (!Objects.equals(createdAt, user.createdAt)) {
            return false;
        }
        if (!Objects.equals(behaviors, user.behaviors)) {
            return false;
        }
        return Objects.equals(following, user.following);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (profileInfo != null ? profileInfo.hashCode() : 0);
        result = 31 * result + (preferences != null ? preferences.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (behaviors != null ? behaviors.hashCode() : 0);
        result = 31 * result + (following != null ? following.hashCode() : 0);
        return result;
    }
}







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

    @Column(nullable = false)
    private String password;


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


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
   private Set<Role> roles;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profileInfo='" + profileInfo + '\'' +
                ", preferences='" + preferences + '\'' +
                ", createdAt=" + createdAt +
                ", behaviors=" + behaviors +
                ", following=" + following +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(profileInfo, user.profileInfo) && Objects.equals(preferences, user.preferences) && Objects.equals(createdAt, user.createdAt) && Objects.equals(behaviors, user.behaviors) && Objects.equals(following, user.following) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, profileInfo, preferences, createdAt, behaviors, following, roles);
    }
}







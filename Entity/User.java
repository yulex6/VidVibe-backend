import javax.persistence.*;
import java.util.Set;

// 用户(User)实体
@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
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


}







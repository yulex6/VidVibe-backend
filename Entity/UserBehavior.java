// 用户行为(UserBehavior)实体
@Entity
@Table(name = "UserBehavior")
@Data
@NoArgsConstructor
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

    // 省略getter和setter方法...

    public enum ActionType {
        VIEW,
        LIKE,
        SHARE,
        COMMENT
    }
}
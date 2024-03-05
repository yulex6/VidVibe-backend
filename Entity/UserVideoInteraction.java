// 用户-视频交互评分(UserVideoInteraction)实体
@Entity
@Table(name = "UserVideoInteraction")
@Data
@NoArgsConstructor
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

    @Column(precision = 10, scale = 2)
    private Double interactionScore;

    // 省略getter和setter方法...
}
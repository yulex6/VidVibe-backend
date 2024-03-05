import javax.persistence.*;
import java.util.Set;

// 视频(Video)实体
@Entity
@Table(name = "Videos")
@Data
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    private String description;

    private Integer duration; // 假设以秒为单位

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;

    private Long viewsCount;

    private Long likesCount;

    // 多对多关系 - 视频与标签（通过中间表VideoTags）
    @ManyToMany(mappedBy = "videos", cascade = CascadeType.ALL)
    private Set<Tag> tags;

    // 省略getter和setter方法...
}

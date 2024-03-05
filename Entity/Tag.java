// 标签(Tag)实体
@Entity
@Table(name = "Tags")
@Data
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(nullable = false, unique = true, length = 100)
    private String tagName;

    // 多对多关系 - 标签与视频（通过中间表VideoTags）
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "VideoTags",
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "video_id")
    )
    private Set<Video> videos;

    // 省略getter和setter方法...
}
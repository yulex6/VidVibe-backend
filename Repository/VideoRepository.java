// 视频表(Video)的Repository接口
@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    // 自定义查询方法示例
    List<Video> findByTags(Tag tag); // 根据标签查找视频
}
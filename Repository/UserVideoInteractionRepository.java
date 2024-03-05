// 用户-视频交互评分表(UserVideoInteraction)的Repository接口
@Repository
public interface UserVideoInteractionRepository extends JpaRepository<UserVideoInteraction, Integer> {
    // 自定义查询方法示例
    List<UserVideoInteraction> findByUserAndInteractionScoreGreaterThan(User user, Double minScore);
}
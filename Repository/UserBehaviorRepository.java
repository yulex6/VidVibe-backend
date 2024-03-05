// 用户行为表(UserBehavior)的Repository接口
@Repository
public interface UserBehaviorRepository extends JpaRepository<UserBehavior, Integer> {
    // 自定义查询方法示例
    List<UserBehavior> findByUserAndActionType(User user, UserBehavior.ActionType actionType);
}
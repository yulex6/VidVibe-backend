package com.example.vidvibebackend.Repository;

import com.example.vidvibebackend.Entity.User;
import com.example.vidvibebackend.Entity.UserBehavior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhenliang Yu
 */
// 用户行为表(UserBehavior)的Repository接口
@Repository
public interface UserBehaviorRepository extends JpaRepository<UserBehavior, Integer> {
    // 自定义查询方法示例
    List<UserBehavior> findByUserAndActionType(User user, UserBehavior.ActionType actionType);
}
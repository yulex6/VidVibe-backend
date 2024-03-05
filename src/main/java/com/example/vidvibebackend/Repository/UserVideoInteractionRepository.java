package com.example.vidvibebackend.Repository;

import com.example.vidvibebackend.Entity.User;
import com.example.vidvibebackend.Entity.UserVideoInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhenliang Yu
 */
// 用户-视频交互评分表(UserVideoInteraction)的Repository接口
@Repository
public interface UserVideoInteractionRepository extends JpaRepository<UserVideoInteraction, Integer> {


}
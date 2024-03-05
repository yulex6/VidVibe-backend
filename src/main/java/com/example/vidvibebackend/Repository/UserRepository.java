package com.example.vidvibebackend.Repository;

import com.example.vidvibebackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 用户表(User)的Repository接口
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 如果需要自定义查询方法，可以在这里添加
    // 例如：根据用户名查找用户
    Optional<User> findByUsername(String username);
}
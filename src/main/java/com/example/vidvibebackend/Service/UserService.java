package com.example.vidvibebackend.Service;

import com.example.vidvibebackend.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

/**
 * @author Zhenliang Yu
 */
public interface UserService extends UserDetailsService {

    // 获取用户信息
    User getUserById(Integer userId);

    //注册用户
    User register(User user);

    // 删除用户（根据ID）
    void deleteUser(Integer userId);

    void updateUserTags(Integer userId, Set<String> tags);
    // 用户关注另一个用户
    void followUser(User follower, User followed);

    // 用户取消关注另一个用户
    void unfollowUser(User follower, User followed);


    // 获取某个用户的关注列表
    Set<User> getFollowingOfUser(Integer userId);

    // 分页获取用户列表（可选，如果需要提供用户列表查询功能的话）
    Page<User> getUsers(int page, int size);
}
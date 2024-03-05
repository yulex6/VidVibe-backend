package com.example.vidvibebackend.Service.Impl;

import com.example.vidvibebackend.Entity.User;
import com.example.vidvibebackend.Repository.UserRepository;
import com.example.vidvibebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    /**
     * 获取用户信息
     */
    @Override
    public User getUserById(Integer userId) {
//        return userRepository.findById(userId).orElse(null);
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    /**
     * 用户关注另一个用户
     */
    @Override
    public void followUser(User follower, User followed) {
//        Set<User> followers = followed.getFollowing();
//        followers.add(follower);
//
//        Set<User> following = follower.getFollowing();
//        following.add(followed);
//
//        // 保存到数据库（假设是双向关系）
//        userRepository.saveAndFlush(followed);
//        userRepository.saveAndFlush(follower);

    }

    /**
     * 用户取消关注另一个用户
     */
    @Override
    public void unfollowUser(User follower, User followed) {
//        Set<User> followers = followed.getFollowing();
//        followers.remove(follower);
//
//        Set<User> following = follower.getFollowing();
//        following.remove(followed);
//
//        // 更新并保存到数据库
//        userRepository.saveAndFlush(followed);
//        userRepository.saveAndFlush(follower);


    }
    /**
     * 获取某个用户的关注者列表
     */
    @Override
    public Set<User> getFollowersOfUser(Integer userId) {
        return null;
    }
    /**
     * 获取某个用户的关注列表
     */
    @Override
    public Set<User> getFollowingOfUser(Integer userId) {
        return null;
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return null;
    }


}
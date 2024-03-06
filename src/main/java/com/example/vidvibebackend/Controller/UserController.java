package com.example.vidvibebackend.Controller;

import com.example.vidvibebackend.Entity.ResponseResult;
import com.example.vidvibebackend.Entity.User;
import com.example.vidvibebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Zhenliang Yu
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户
     *
     * @param userId 用户id
     * @return {@link User}
     */
    @GetMapping("/{userId}")
    public ResponseResult<User>  getUser(@PathVariable("userId") Integer userId) {
        return ResponseResult.success(userService.getUserById(userId));
    }

    /**
     * 关注用户
     *
     * @param userId         用户id
     * @param followedUserId 关注用户id
     */
    @PostMapping("/{userId}/follow/{followedUserId}")
    public ResponseResult<String> followUser(@PathVariable("userId") Integer userId,
                           @PathVariable("followedUserId") Integer followedUserId) {
        // 需要先从数据库中加载这两个用户对象
        User follower = userService.getUserById(userId);
        User followed = userService.getUserById(followedUserId);

        userService.followUser(follower, followed);
        return  ResponseResult.success("取消关注成功");
    }

    /**
     * 取消关注用户
     *
     * @param userId         用户id
     * @param followedUserId 关注用户id
     */
    @DeleteMapping("/{userId}/unfollow/{followedUserId}")
    public ResponseResult<String> unfollowUser(@PathVariable("userId") Integer userId,
                             @PathVariable("followedUserId") Integer followedUserId) {
        User follower = userService.getUserById(userId);
        User followed = userService.getUserById(followedUserId);

        userService.unfollowUser(follower, followed);
        return  ResponseResult.success("取消关注成功");
    }

    /**
     * 获取关注列表
     *
     * @param userId 用户id
     * @return {@link Set}<{@link User}>
     */
    @GetMapping("/{userId}/followers")
    public ResponseResult<Set<User>> getFollowers(@PathVariable("userId") Integer userId) {
        User user = userService.getUserById(userId);
        return ResponseResult.success(userService.getFollowingOfUser(user.getUserId())) ;
    }

    /**
     * 更新tags
     *
     * @param userId 用户id
     * @param tags   标签
     * @return {@link ResponseEntity}<{@link ?}>
     */
    @PutMapping("/tags/{userId}")
    public ResponseResult<String> updateTags(@PathVariable Integer userId, @RequestBody Set<String> tags) {
        userService.updateUserTags(userId, tags);

        return ResponseResult.success("User tags updated successfully");
    }
}
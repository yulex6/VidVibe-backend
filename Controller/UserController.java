import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    // 假设前端发送的是被关注者的ID
    @PostMapping("/{userId}/follow/{followedUserId}")
    public void followUser(@PathVariable("userId") Integer userId,
                           @PathVariable("followedUserId") Integer followedUserId) {
        // 需要先从数据库中加载这两个用户对象
        User follower = userService.getUserById(userId);
        User followed = userService.getUserById(followedUserId);

        userService.followUser(follower, followed);
    }

    @DeleteMapping("/{userId}/unfollow/{followedUserId}")
    public void unfollowUser(@PathVariable("userId") Integer userId,
                             @PathVariable("followedUserId") Integer followedUserId) {
        User follower = userService.getUserById(userId);
        User followed = userService.getUserById(followedUserId);

        userService.unfollowUser(follower, followed);
    }

    @GetMapping("/{userId}/followers")
    public Set<User> getFollowers(@PathVariable("userId") Integer userId) {
        User user = userService.getUserById(userId);
        return userService.getFollowersOfUser(user);
    }

    @GetMapping("/{userId}/following")
    public Set<User> getFollowing(@PathVariable("userId") Integer userId) {
        User user = userService.getUserById(userId);
        return userService.getFollowingOfUser(user);
    }
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implement UserService {

    @Autowired
    private UserRepository userRepository;



    /**
     * 获取用户信息
     */
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * 用户关注另一个用户
     */
    public void followUser(User follower, User followed) {
        Set<User> followers = followed.getFollowing();
        followers.add(follower);

        Set<User> following = follower.getFollowing();
        following.add(followed);

        // 保存到数据库（假设是双向关系）
        userRepository.saveAndFlush(followed);
        userRepository.saveAndFlush(follower);

    }

    /**
     * 用户取消关注另一个用户
     */
    public void unfollowUser(User follower, User followed) {
        Set<User> followers = followed.getFollowing();
        followers.remove(follower);

        Set<User> following = follower.getFollowing();
        following.remove(followed);

        // 更新并保存到数据库
        userRepository.saveAndFlush(followed);
        userRepository.saveAndFlush(follower);


    }

    /**
     * 获取某个用户的关注者列表
     */
    public Set<User> getFollowersOfUser(User user) {
        return user.getFollowing();
    }

    /**
     * 获取某个用户的关注列表
     */
    public Set<User> getFollowingOfUser(User user) {
        return user.getFollowing();
    }
}
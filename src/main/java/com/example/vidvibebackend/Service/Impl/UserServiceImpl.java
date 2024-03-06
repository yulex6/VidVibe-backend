package com.example.vidvibebackend.Service.Impl;

import com.example.vidvibebackend.Entity.Role;
import com.example.vidvibebackend.Entity.User;
import com.example.vidvibebackend.Repository.UserRepository;
import com.example.vidvibebackend.Service.UserService;
import com.example.vidvibebackend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Zhenliang Yu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 获取用户信息
     */
    @Override
    public User getUserById(Integer userId) {
        User user = userRepository.findUserByUserId(userId).orElse(null);
        if (user != null)
        {
            user.setPassword("********");
            return user;
        }else {
            return null;
        }
    }

    @Override
    public User register(User user) {
        // 对密码进行加密等操作
        // ...
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public void updateUserTags(Integer userId, Set<String> tags) {
        User user = userRepository.findUserByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        user.setPreferences(tags.toString());
        userRepository.save(user);
    }

    /**
     * 用户关注另一个用户
     */
    @Override
    public void followUser(User cur, User target) {
        Set<User> followers = cur.getFollowing();
        followers.add(target);
        userRepository.saveAndFlush(cur);
    }

    /**
     * 用户取消关注另一个用户
     */
    @Override
    public void unfollowUser(User cur, User target) {
        Set<User> followers = cur.getFollowing();
        followers.remove(target);
        userRepository.saveAndFlush(cur);
    }
    /**
     * 获取某个用户的关注列表
     */
    @Override
    public Set<User> getFollowingOfUser(Integer userId) {
        User user = userRepository.findUserByUserId(userId).orElse(null);
        if (user != null)
        {
            return  user.getFollowing();
        }else {
            return null;
        }
    }

    @Override
    public Page<User> getUsers(int page, int size) {
        // 创建一个Pageable对象，传入当前页数（从0开始）和每页大小
        Pageable pageable = PageRequest.of(page, size);

        // 调用userRepository中的getUsers方法进行分页查询
        return userRepository.getUsers(pageable);
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
              List<GrantedAuthority> authorities = new ArrayList<>();
              for (Role role : roles) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()));
                  }
               return authorities;
    }
}
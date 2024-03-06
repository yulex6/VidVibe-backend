package com.example.vidvibebackend.Entity;

import com.example.vidvibebackend.Entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Zhenliang Yu
 */
public class UserRegistrationRequest {

    // 用户名，非空且长度限制
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 20, message = "用户名长度需在3到20个字符之间")
    private String username;

    // 密码，非空且长度限制
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度至少为6个字符")
    private String password;

    // 邮箱，非空，并使用邮箱验证注解（假设已经定义了自定义的Email验证注解）
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "请输入有效的电子邮件地址")
    private String email;

    // 其他可能需要的字段，例如：手机号、验证码、同意条款等

    // 构造函数（可选）
    public UserRegistrationRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getter和Setter方法
    // ...

    // 可以添加一个toUser()方法，将请求对象转换为实际的User实体对象
    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}
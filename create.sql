-- 创建数据库 VidVibe
CREATE DATABASE IF NOT EXISTS VidVibe
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE VidVibe;

-- 用户表(User)
CREATE TABLE IF NOT EXISTS Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    profile_info TEXT,
    preferences TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 视频表(Video)
CREATE TABLE IF NOT EXISTS Videos (
    video_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    duration INT, -- 假设以秒为单位
    upload_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    views_count BIGINT DEFAULT 0,
    likes_count BIGINT DEFAULT 0,
    collect_count BIGINT DEFAULT 0,
    comment_count BIGINT DEFAULT 0,
    tags TEXT
);

-- 标签表(Tag)
CREATE TABLE IF NOT EXISTS Tags (
    tag_id INT AUTO_INCREMENT PRIMARY KEY,
    tag_name VARCHAR(100) NOT NULL UNIQUE
);

-- 视频-标签关联表(VideoTags)
CREATE TABLE IF NOT EXISTS VideoTags (
    id INT AUTO_INCREMENT PRIMARY KEY,
    video_id INT,
    tag_id INT,
    FOREIGN KEY (video_id) REFERENCES Videos(video_id),
    FOREIGN KEY (tag_id) REFERENCES Tags(tag_id)
);

-- 用户行为表(UserBehavior)
CREATE TABLE IF NOT EXISTS UserBehavior (
    behavior_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    video_id INT,
    action_type ENUM('view', 'like', 'share', 'comment','collect'), -- 或者使用其他枚举类型
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- 用户-视频交互评分表(UserVideoInteraction)
CREATE TABLE IF NOT EXISTS UserVideoInteraction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    video_id INT,
    interaction_score DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- 关注表(Following)
CREATE TABLE IF NOT EXISTS Following (
    follower_id INT,
    followed_id INT,
    PRIMARY KEY (follower_id, followed_id),
    FOREIGN KEY (follower_id) REFERENCES Users(user_id),
    FOREIGN KEY (followed_id) REFERENCES Users(user_id)
);
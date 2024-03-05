package com.example.vidvibebackend.Repository;

import com.example.vidvibebackend.Entity.Tag;
import com.example.vidvibebackend.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhenliang Yu
 */
// 视频表(Video)的Repository接口
@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByTags(Tag tag); // 根据标签查找视频
}
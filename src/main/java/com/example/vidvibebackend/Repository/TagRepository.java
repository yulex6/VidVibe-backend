package com.example.vidvibebackend.Repository;

import com.example.vidvibebackend.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zhenliang Yu
 */
// 标签表(Tag)的Repository接口
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    // ...
}
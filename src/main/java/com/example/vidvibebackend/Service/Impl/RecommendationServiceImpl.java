package com.example.vidvibebackend.Service.Impl;

import com.example.vidvibebackend.Entity.Video;
import com.example.vidvibebackend.Service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * @author Zhenliang Yu
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Override
    public List<Video> getItemCfVideos(String userId) {
        return null;
    }

    @Override
    public List<Video> getHotRankVideos() {
        return null;
    }

    @Override
    public List<Video> getTagBasedVideos(String userId) {
        return null;
    }

    @Override
    public List<Video> getFollowingVideos(String userId) {
        return null;
    }
}
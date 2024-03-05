package com.example.vidvibebackend.Controller;

import com.example.vidvibebackend.Entity.ResponseResult;
import com.example.vidvibebackend.Entity.Video;
import com.example.vidvibebackend.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    /**
     * 根据ItemCF算法返回推荐短视频
     */
    @GetMapping("/recommend/itemcf")
    public
    ResponseResult<List<Video>> getItemCfRecommendations(@RequestParam("userId") String userId) {
        List<Video> recommendations = recommendationService.getItemCfVideos(userId);
        if (recommendations != null && !recommendations.isEmpty()) {
            return ResponseResult.success(recommendations);
        } else {
            return ResponseResult.fail(404, "未找到推荐内容");
        }
    }

    /**
     * 返回热门排行推荐短视频
     */
    @GetMapping("/recommend/hot")
    public ResponseResult<List<Video>> getHotRankRecommendations() {
        List<Video> hotRankVideos = recommendationService.getHotRankVideos();
        if (hotRankVideos != null && !hotRankVideos.isEmpty()) {
            return ResponseResult.success(hotRankVideos);
        } else {
            return ResponseResult.fail(404, "未找到推荐内容");
        }
    }

    /**
     * 根据用户关注的标签返回推荐短视频
     */
    @GetMapping("/recommend/tags")
    public ResponseResult<List<Video>> getTagBasedRecommendations(@RequestParam("userId") String userId) {
        List<Video> tagBasedVideos = recommendationService.getTagBasedVideos(userId);
        if (tagBasedVideos != null && !tagBasedVideos.isEmpty()) {
            return ResponseResult.success(tagBasedVideos);
        } else {
            return ResponseResult.fail(404, "未找到推荐内容");
        }
    }

    /**
     * 根据用户关注的人返回推荐短视频
     */
    @GetMapping("/recommend/following")
    public ResponseResult<List<Video>> getFollowingRecommendations(@RequestParam("userId") String userId) {
        List<Video> followingVideos = recommendationService.getFollowingVideos(userId);
        if (followingVideos != null && !followingVideos.isEmpty()) {
            return ResponseResult.success(followingVideos);
        } else {
            return ResponseResult.fail(404, "未找到推荐内容");
        }
    }
}
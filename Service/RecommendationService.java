import org.springframework.stereotype.Service;
import java.util.List;


public interface RecommendationService {

    /**
     * 根据ItemCF算法获取推荐短视频列表
     * @param userId 用户ID
     * @return 推荐的短视频列表
     */
    List<Recommendation> getItemCfRecommendations(String userId);

    /**
     * 获取热门排行推荐短视频列表
     * @return 热门的短视频列表
     */
    List<Recommendation> getHotRankRecommendations();

    /**
     * 根据用户关注的标签获取推荐短视频列表
     * @param userId 用户ID
     * @return 标签相关的短视频列表
     */
    List<Recommendation> getTagBasedRecommendations(String userId);

    /**
     * 根据用户关注的人获取推荐短视频列表
     * @param userId 用户ID
     * @return 关注人发布的短视频列表
     */
    List<Recommendation> getFollowingRecommendations(String userId);
}


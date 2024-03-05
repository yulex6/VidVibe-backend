import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService RecommendationService;

    /**
     * 根据ItemCF算法返回推荐短视频
     */
    @GetMapping("/recommend/itemcf")
    public List<Recommendation> getItemCfRecommendations(@RequestParam("userId") String userId) {
        List<Recommendation> recommendations = RecommendationService.getItemCfRecommendations(userId);
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
    public List<Recommendation> getHotRankRecommendations() {
        return RecommendationService.getHotRankRecommendations();
    }

    /**
     * 根据用户关注的标签返回推荐短视频
     */
    @GetMapping("/recommend/tags")
    public List<Recommendation> getTagBasedRecommendations(@RequestParam("userId") String userId) {
        return RecommendationService.getTagBasedRecommendations(userId);
    }

    /**
     * 根据用户关注的人返回推荐短视频
     */
    @GetMapping("/recommend/following")
    public List<Recommendation> getFollowingRecommendations(@RequestParam("userId") String userId) {
        return RecommendationService.getFollowingRecommendations(userId);
    }
}
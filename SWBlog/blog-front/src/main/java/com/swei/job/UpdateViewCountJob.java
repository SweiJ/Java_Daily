package com.swei.job;

import com.swei.constants.SystemConstants;
import com.swei.entity.Article;
import com.swei.service.ArticleService;
import com.swei.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 10:00
 */
@Component
public class UpdateViewCountJob {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleService articleService;

    /**
     * 每隔60秒执行一次 将redis中的浏览量信息添加到数据库
     */
    @Scheduled(cron = "0/55 * * * * ?")
    public void updateViewCount() {
        // 查询redis中的浏览量
        Map<String, Integer> viewCountMap = redisCache.getCacheMap(SystemConstants.ARTICLEVIEWCOUNT);

        if(ObjectUtils.isEmpty(viewCountMap)) {
            return;
        }
        List<Article> articles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                .collect(Collectors.toList());

        // 更新到数据库
        articleService.updateBatchById(articles);
    }

//    @Scheduled(cron = "0/5 * * * * ?")
//    public void test() {
//        System.out.println("定时器执行了!");
//    }
}

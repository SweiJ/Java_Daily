package com.swei.runner;

import com.swei.constants.SystemConstants;
import com.swei.entity.Article;
import com.swei.mapper.ArticleMapper;
import com.swei.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 9:36
 */
@Component
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public void run(String... args) throws Exception {
        // 查询博客信息 id viewCount
        List<Article> articles = articleMapper.selectList(null);

        Map<String, Integer> viewCountMap = articles.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(),
                        article -> article.getViewCount().intValue()));

        redisCache.setCacheMap(SystemConstants.ARTICLEVIEWCOUNT, viewCountMap);
    }
}

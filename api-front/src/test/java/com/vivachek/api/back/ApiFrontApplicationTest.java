package com.vivachek.api.back;

import com.github.pagehelper.PageInfo;
import com.vivachek.core.domain.Article;
import com.vivachek.core.domain.req.PageParam;
import com.vivachek.core.utils.PageUtils;
import com.vivachek.service.ArticleService;
import com.vivachek.service.dao.ArticleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/9 13:26
 */
@SpringBootTest
public class ApiFrontApplicationTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleService articleService;

    @Test
    public void test1(){

    }
}
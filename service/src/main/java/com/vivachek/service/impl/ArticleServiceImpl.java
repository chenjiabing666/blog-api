package com.vivachek.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vivachek.core.domain.Article;
import com.vivachek.core.domain.oath.UserInfoVO;
import com.vivachek.core.domain.req.ArticleAddReq;
import com.vivachek.core.domain.req.ArticleListReq;
import com.vivachek.core.domain.rs.PageData;
import com.vivachek.core.utils.AssertUtils;
import com.vivachek.core.utils.OathUtils;
import com.vivachek.core.utils.PageUtils;
import com.vivachek.service.ArticleService;
import com.vivachek.service.dao.ArticleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 14:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public void add(ArticleAddReq req) {
        Article article = Article.builder()
                .createTime(new Date())
                .status(1)
                .id(UUID.randomUUID().toString())
                .userId(OathUtils.getUserInfo().getId())
                .build();
        BeanUtils.copyProperties(req,article);
        int i = articleMapper.insertSelective(article);
        AssertUtils.assertTrue(i==1);
    }

    @Override
    public PageData<Article> getAll(ArticleListReq req) {
        return PageUtils.getPageInfo(req.getPageNum(),req.getPageSize(),()->articleMapper.selectAll());
    }
}
package com.vivachek.core.utils;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vivachek.core.domain.req.PageParam;
import com.vivachek.core.domain.rs.PageData;
import org.springframework.beans.BeanUtils;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/10 16:09
 */
public class PageUtils {
    public static <T> PageData<T> getPageInfo(PageParam pageParam, ISelect select){
        PageInfo<Object> pageInfo = PageHelper.startPage(pageParam).doSelectPageInfo(select);
        PageData<T> data = new PageData<>();
        BeanUtils.copyProperties(pageInfo,data);
        return data;
    }
}
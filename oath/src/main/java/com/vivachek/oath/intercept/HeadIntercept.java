package com.vivachek.oath.intercept;

import com.vivachek.core.domain.oath.HeadParam;
import com.vivachek.core.domain.oath.RequestConfigInfo;
import com.vivachek.core.exception.HeadInvaildException;
import com.vivachek.core.processor.HeadPostProcessor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.apache.el.util.ConcurrentCache;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Set;

/**
 * @Description 抽象类，请求头拦截器，可覆盖
 * @Author CJB
 * @Date 2020/3/9 17:17
 */
@Component
public class HeadIntercept implements HandlerInterceptor {




    /**
     * 获取请求头，父类可覆盖或者继承
     * @param request
     * @return
     */
    protected  HeadParam getHeadParam(@Nonnull HttpServletRequest request){
        //获取请求头中的数据
        return HeadParam.builder()
                .clientId(request.getHeader("clientId"))
                .accessToken(request.getHeader("accessToken"))
                .refreshToken(request.getHeader("refreshToken"))
                .platform(request.getHeader("platform"))
                .version(request.getHeader("version"))
                .build();
    }


    /**
     * 校验，可覆盖
     * @param headParam
     * @throws HeadInvaildException  请求头校验异常
     */
    protected void validationHeadParam(@Nonnull HeadParam headParam)throws HeadInvaildException{
        if (StringUtils.isAnyEmpty(Objects.requireNonNull(headParam).getClientId(),Objects.requireNonNull(headParam).getPlatform()))
            throw new HeadInvaildException();
    }


    /**
     * 在处理之前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        doBeforeHandle();
        //获取请求头中的数据
        HeadParam headParam=this.getHeadParam(request);
        //校验
        validationHeadParam(headParam);
        //设置在request中
        request.setAttribute(RequestConfigInfo.HEAD_INFO,headParam);
        //后置处理器
        doAfterHandle();
        return true;
    }


    /**
     * 执行请求头的前置处理器
     */
    private void doBeforeHandle(){

    }


    /**
     * 执行请求头的后置处理器
     */
    private void doAfterHandle(){

    }


    /**
     * 获取ioc容器中所有的HeadPostProcessor，并且根据优先级排序
     * @return
     */
    private Set<HeadPostProcessor> doGetHeadPostProcessor(){
        return null;
    }
}
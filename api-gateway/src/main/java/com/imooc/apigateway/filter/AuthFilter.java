package com.imooc.apigateway.filter;

import com.imooc.apigateway.constant.RedisConstant;
import com.imooc.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName
 * @Description: 权限拦截，区分卖家和买家
 * @Author jiangchengyu
 * @Date 2019/11/18
 * @Version V1.0
 **/
//@Component
public class AuthFilter extends ZuulFilter {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        /**
         * /order/create   只能买家访问（cookie有openid）
         * /order/finish   只能卖家访问 （cookie有token， 并且redis 有值）
         * /product/list   都可以访问
         */
        if ("/order/order/create".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request, "openid");
            if (cookie == null
                    || StringUtils.isEmpty(cookie.getValue())){
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        if ("/order/order/finish".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request, "token");
            if (cookie == null
                    || StringUtils.isEmpty(cookie.getValue())
                    || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        return null;
    }
}

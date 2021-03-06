package com.imooc.apigateway.filter;

import com.imooc.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName TokenFilter
 * @Description: token 过滤器
 * @Author jiangchengyu
 * @Date 2019/11/18
 * @Version V1.0
 **/
@Component
public class TokenFilter extends ZuulFilter {
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

        // 从URL参数获取，也可以从cookie、header获取
        String token = request.getParameter("token");
        Cookie cookie = CookieUtil.get(request, "openid");
        if (cookie == null
                || StringUtils.isEmpty(cookie.getValue())){
            if (StringUtils.isEmpty(token)) {
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }
        return null;
    }
}

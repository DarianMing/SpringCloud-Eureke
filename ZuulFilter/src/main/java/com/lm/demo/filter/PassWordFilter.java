package com.lm.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PassWordFilter
 * @Description TODO
 * @Author Admin
 * @DATE 2018/12/25 18:31
 **/
public class PassWordFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PassWordFilter.class);

    @Override
    public String filterType() {
        return "post"; // 请求处理完成后执行的filter
    }

    @Override
    public int filterOrder() {
        return 1; // 优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 判断上一个过滤器结果为true，否则就不走下面过滤器，直接跳过后面的所有过滤器并返回 上一个过滤器不通过的结果。
        return (boolean) ctx.get("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("---->>>> PassWordFilter {} , {} " , request.getMethod() , request.getRequestURL().toString());
        String pwd = request.getParameter("password");
        if (null != pwd && pwd.equals("123456")) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess" , true);
        } else {
            ctx.setSendZuulResponse(false);//不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("The password cannot be empty");
            ctx.set("isSuccess" , false);
        }
        return null;
    }
}

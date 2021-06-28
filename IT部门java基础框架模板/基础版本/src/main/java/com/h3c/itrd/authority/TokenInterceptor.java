package com.h3c.itrd.authority;


import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.h3c.itrd.common.entity.Result;
import com.h3c.itrd.config.JWTConfig;
import com.h3c.itrd.util.UserUtils;


/**
* Token 拦截器
*/
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
	
    private static Logger log = LoggerFactory.getLogger(TokenInterceptor.class);
    
    @Resource
    private JWTConfig jwtConfig ;
    @Value(value="${sso.main.allowedpath}")
    private  String ALLOWED_PATHS;
    
    
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
    
        
        //String url =request.getServletPath() ;
        // Token 验证
        String token = request.getHeader(jwtConfig.getHeader());
        String uri = request.getRequestURI();
//        System.out.println("test---"  +   uri);
        log.info("git-m  -- uri     " + uri);
        String[] strArray = ALLOWED_PATHS.split(";");
        if(StringUtils.isBlank(token) && Arrays.asList(strArray).contains(uri)) {
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");           
            return true;
        }
        Claims claims = jwtConfig.getTokenClaim(token);
        if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
        	returnJson(response);     
        }else{
            String domainAccount = UserUtils.getCurrentDomainAccountByTicket(claims.getSubject());
        	request.setAttribute("account", domainAccount);
        	
        }
        return true;       
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
        
    }
    
    private void returnJson(HttpServletResponse response) {
    	PrintWriter writer = null;
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json;charset=utf-8");
    	try {
    		writer = response.getWriter();
    		Result res = new Result(false,20801,jwtConfig.getHeader() + "失效，请重新获取token");
    		writer.print(JSON.toJSON(res));
//    		writer.flush();
    	}catch(IOException e) {
    		e.printStackTrace();
    		System.out.println(jwtConfig.getHeader() + "失效，请重新获取token");
    	}finally {
    		if(writer != null) {
    			writer.close();
    		}
    	}
    }

 
}

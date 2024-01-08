package com.oasis.admin.common.security.filter;


import com.oasis.admin.common.constant.Constants;
import com.oasis.admin.common.utils.RedisUtils;
import com.oasis.admin.modules.system.model.entity.system.SysUser;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //1获取token  header的token
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token)) {
            token = token.replace("Bearer ", "");
            //2解析token
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey("qwerty")
                        .parseClaimsJws(token)
                        .getBody();



                String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
                SysUser loginUser = redisUtils.getCacheObject("login_tokens:" + uuid);

                if(loginUser == null){
                    throw new RuntimeException();
                }


                //4封装Authentication
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(loginUser, null, null);
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //5存入SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } catch (Exception e) {
                throw new RuntimeException("token不合法！");
            }
        }
        //放行，让后面的过滤器执行
        filterChain.doFilter(request, response);
    }
}



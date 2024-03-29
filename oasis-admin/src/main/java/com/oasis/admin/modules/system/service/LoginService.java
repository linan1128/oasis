package com.oasis.admin.modules.system.service;


import com.oasis.admin.common.constant.Constants;
import com.oasis.admin.common.security.model.SecurityUserDetails;
import com.oasis.admin.common.utils.RedisUtils;
import com.oasis.admin.modules.system.model.entity.system.SysUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class LoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisUtils redisCache;

    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        //校验失败了
        if(Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误！");
        }
        // 如果验证通过了，从返回的authentication里获得完整的UserDetails信息
        SecurityUserDetails loginUser = (SecurityUserDetails) authentication.getPrincipal();


        String token = UUID.randomUUID().toString().replaceAll("-", "");
        loginUser.setToken(token);

//        String userId = loginUser.getSysUser().getId().toString();
        redisCache.setCacheObject("login_tokens:"+token,loginUser.getSysUser());


        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);


        String secret = "qwerty";

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();


        return jwt;
    }
}

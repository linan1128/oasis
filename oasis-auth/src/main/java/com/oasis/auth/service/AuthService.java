package com.oasis.auth.service;


import com.oasis.auth.model.SecurityUserDetails;
import com.oasis.cache.redis.RedisCache;
import com.oasis.model.entity.system.SysUser;
import com.oasis.util.jwt.JwtUtil;
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
public class AuthService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    public String login(SysUser user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        //校验失败了
        if(Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误！");
        }
        // 如果验证通过了，从返回的authentication里获得完整的UserDetails信息
        SecurityUserDetails loginUser = (SecurityUserDetails) authentication.getPrincipal();


        String token = UUID.randomUUID().toString().replaceAll("-", "");
        loginUser.setToken(token);

        String userId = loginUser.getSysUser().getId().toString();
        redisCache.setCacheObject("login_tokens:"+token,loginUser.getSysUser());


        Map<String, Object> claims = new HashMap<>();
        claims.put("login_user_key", token);


        String secret = "qwerty";

        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();


        return jwt;
    }
}

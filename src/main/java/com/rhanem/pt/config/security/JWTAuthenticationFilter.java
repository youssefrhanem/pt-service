package com.rhanem.pt.config.security;

import com.rhanem.pt.service.UserDetailService;
import com.rhanem.pt.utils.JwtHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;



@Slf4j
@AllArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private UserDetailService customUserDetailService;
    private JwtHelper jwt;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String TOKEN = jwt.getToken(request);
        if (StringUtils.hasText(TOKEN)) {
            String USER_NAME = jwt.getUsernameFromToken(TOKEN);
            if (null!=USER_NAME) {
                UserDetails user = customUserDetailService.loadUserByUsername(USER_NAME);
                if (jwt.validateToken(TOKEN, user)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            user, null, user.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }else {
                log.error("username is null");
            }
        }else {
            log.error("the request doesn't have token");
        }
        filterChain.doFilter(request, response);

    }
}

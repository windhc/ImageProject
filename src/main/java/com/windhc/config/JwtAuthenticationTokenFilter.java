package com.windhc.config;

import com.windhc.domain.User;
import com.windhc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author windhc
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        String authToken = request.getHeader(this.tokenHeader);
        if (StringUtils.isNotEmpty(authToken)) {
            Long userId = null;
            try {
                userId = Long.valueOf(jwtTokenService.getUserIdFromToken(authToken));
            } catch (Exception e) {
                LOGGER.warn("parse token error");
            }
            if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                User user = userService.findOne(userId);

                // 校验jwt token是否正确
                if (jwtTokenService.validateToken(authToken, user)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            user, null, user.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        chain.doFilter(request, response);
    }
}

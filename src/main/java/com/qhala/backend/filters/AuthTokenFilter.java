package com.qhala.backend.filters;

import com.qhala.backend.services.MyDetailsUserService;
import com.qhala.backend.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    private final MyDetailsUserService myUserDetailsService;

    public AuthTokenFilter(JWTUtils jwtUtils, MyDetailsUserService myUserDetailsService) {
        this.jwtUtils = jwtUtils;
        this.myUserDetailsService = myUserDetailsService;
    }

    @Qualifier("myUserDetailsService")
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
            ServletException, IOException {
        final  String authorizationHeader =request.getHeader("Authorization");
        String username=null;
        String jwt = parseJwt(request);

        if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")){
            jwt=authorizationHeader.substring(6);
            username=jwtUtils.extractUsername(jwt);

        }

        try {
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                if (jwtUtils.validateToken(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }
            }
        }catch (Exception e){
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            return headerAuth.substring(6);
        }
        return null;
    }
}

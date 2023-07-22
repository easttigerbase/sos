package com.ssoptimus.sos.auth.components;

import com.ssoptimus.sos.auth.filters.JwtTokenProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;


@Log4j2
public class JwtFilter extends GenericFilterBean {
    private JwtTokenProvider jwtTokenProvider;

    public JwtFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest) request);
        System.out.println(token);
        if(token!=null&&this.jwtTokenProvider.validateToken(token)){
            System.out.println("토큰");
            chain.doFilter(request,response);
        }else{
            System.out.println("토큰에라");
            throw new IllegalArgumentException("토큰만료");
        }

    }
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}

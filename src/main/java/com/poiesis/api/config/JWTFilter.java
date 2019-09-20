package com.poiesis.api.config;

import com.poiesis.api.service.TokenService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JWTFilter extends GenericFilterBean {

    private TokenService tokenService;

    @Value("${clientSecret}")
    private String CLIENT_SECRET;

    JWTFilter() {
        this.tokenService = new TokenService();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String token = request.getHeader("Authorization");
        String clientSecret = request.getHeader("x-clientSecret");

        if(clientSecret.equals(CLIENT_SECRET)){

            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                response.sendError(HttpServletResponse.SC_OK, "success");
                return;
            }

            if (allowRequestWithoutToken(request)) {
                response.setStatus(HttpServletResponse.SC_OK);
                filterChain.doFilter(req, res);
            } else {
                if (token == null || !tokenService.isTokenValid(token)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                } else {
                    ObjectId userId = new ObjectId(tokenService.getUserIdFromToken(token));
                    request.setAttribute("userId", userId);
                    filterChain.doFilter(req, res);

                }
            }
        }

    }

    public boolean allowRequestWithoutToken(HttpServletRequest request){
        if (request.getRequestURI().contains("/register")) {
            return true;
        }
        if (request.getRequestURI().contains("/login")) {
            return true;
        }
        return false;
    }

}

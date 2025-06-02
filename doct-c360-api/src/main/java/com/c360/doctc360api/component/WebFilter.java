package com.c360.doctc360api.component;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@Component
public class WebFilter implements Filter {

    // List of blocked websites
    private List<String> blockedWebsites = Arrays.asList("facebook.com", "twitter.com", "instagram.com");
    private static final Logger logger = LoggerFactory.getLogger(WebFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String requestedUrl = httpRequest.getRequestURL().toString();
        if(!(requestedUrl.contains("prometheus")|| requestedUrl.contains("health"))) {
            logger.info(" URl: {}", requestedUrl);
        }
        String host = httpRequest.getHeader("Host");
        if (blockedWebsites.contains(host)) {
            response.getWriter().write("Access to this website is blocked.");
        } else {
            chain.doFilter(request, response);
        }
    }

    // Other filter methods (init, destroy) can be left empty or implemented as needed
}

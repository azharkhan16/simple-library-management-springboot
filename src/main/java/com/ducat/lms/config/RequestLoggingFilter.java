package com.ducat.lms.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    // Logger Object
    private static final Logger logger =
            LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        logger.info("======================================");
        logger.info("API Request:");
        logger.info("Method : {}", request.getMethod());
        logger.info("URL    : {}", request.getRequestURL());
        logger.info("URI    : {}", request.getRequestURI());
        logger.info("Query  : {}", request.getQueryString());
        logger.info("IP     : {}", request.getRemoteAddr());

        filterChain.doFilter(request, response);

        long timeTaken = System.currentTimeMillis() - startTime;

        logger.info("Response Status : {}", response.getStatus());
        logger.info("Time Taken      : {} ms", timeTaken);
        logger.info("======================================");
    }
}
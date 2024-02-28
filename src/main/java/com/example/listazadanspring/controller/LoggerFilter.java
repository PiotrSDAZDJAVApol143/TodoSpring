package com.example.listazadanspring.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class LoggerFilter implements Filter {

 private static final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if(servletRequest instanceof HttpServletRequest){
        var httpRquest = (HttpServletRequest) servletRequest;
        logger.info("[doFilter]" + httpRquest.getMethod() + " " +httpRquest.getRequestURI());
    }
    filterChain.doFilter(servletRequest,servletResponse);
    }



}

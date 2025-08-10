package com.example.moviebooking.filters;


import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ResponseTimeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    long start = System.currentTimeMillis();
    chain.doFilter(request, response);
    long end = System.currentTimeMillis();
    System.out.println("Response Time: " + (end - start) + "ms");
    }
}

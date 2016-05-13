package com.zyncro.server.apigateway.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        addFilters(request, response);

        if (!request.getMethod().equals(HttpMethod.OPTIONS)) {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    public static void addFilters(HttpServletRequest request, HttpServletResponse response) {

        String origin = request.getHeader(HttpHeaders.ORIGIN);
        if (origin == null || origin.equalsIgnoreCase("null")) {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        else {
            response.addHeader("Access-Control-Allow-Origin", origin);
        }

        response.setHeader("Access-Control-Expose-Headers", "Link, X-Zyncro-Page, X-Zyncro-Size, X-Zyncro-Total-Pages, X-Zyncro-Total-Records");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if (request.getMethod().equals(HttpMethod.OPTIONS)) {
            try {
                response.getWriter().print("OK");
                response.getWriter().flush();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

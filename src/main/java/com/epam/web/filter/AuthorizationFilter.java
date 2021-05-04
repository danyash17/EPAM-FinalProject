package com.epam.web.filter;

import com.epam.web.command.Commands;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        ServletContext context = filterConfig.getServletContext();
        if (httpServletRequest.getSession().getAttribute("authorized")!=null||servletRequest.getParameter("command").equals(Commands.LOGIN)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        filterConfig=null;
    }
}

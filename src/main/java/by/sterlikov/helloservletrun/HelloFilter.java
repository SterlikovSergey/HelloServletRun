package by.sterlikov.helloservletrun;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String firstValue = servletRequest.getServletContext()
                        .getInitParameter("First");
        System.out.println("My first value" + firstValue);


        System.out.println("This is my helloFilter");
        if(servletRequest.getParameter("name")==null){
            servletRequest.getRequestDispatcher("error.jsp")
                    .forward(servletRequest,servletResponse);
        } else {
            System.out.println("Hello, " + servletRequest.getParameter("name"));
            filterChain.doFilter(servletRequest,servletResponse);
        }
        PrintWriter writer = servletResponse.getWriter();
        writer.println("This is my response");
        filterChain.doFilter(servletRequest,servletResponse);





    }
}

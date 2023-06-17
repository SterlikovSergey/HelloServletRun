package by.sterlikov.helloservletrun;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("This is my  second filter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

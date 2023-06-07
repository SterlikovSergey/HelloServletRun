package by.sterlikov.helloservletrun;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

@WebServlet(value = "/hi/*")    // /* отправляет в один и тот же мтод любой путь в браузерной строке

public class MySecondServlet extends HttpServlet {
    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 100;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet path " + req.getServletPath());
        System.out.println("Servlet uri " + req.getRequestURI());
        System.out.println("Parameter " + req.getParameter("my"));

        HttpSession session = req.getSession();
        Integer currentParam = (Integer) session.getAttribute("count");
        System.out.println("CountParam :" + currentParam);
        if (currentParam == null) {
            currentParam = counter;
        }
        session.setAttribute("count", currentParam + 1);


        PrintWriter writer = resp.getWriter(); //запиши в ответ
        writer.println("This is My second response ! " + "Current param: " + currentParam);
        Iterator<String> headersIterator = req.getHeaderNames().asIterator();
        while ((headersIterator.hasNext())) {
            writer.println("\nHeader: " + headersIterator.next());
        }
        writer.println("\nHost: " + req.getHeader("host"));
        resp.setHeader("My Header", "asdsd");
        writer.println("\nCookies: " + Arrays.asList(req.getCookies())
                .stream()
                .map(cookies -> cookies.getName() + " " + cookies.getValue() + " " + cookies.getMaxAge())
                .collect(Collectors.toList()));

        resp.sendRedirect("/here");

/*        if(currentParam > 105){      // бросаем ошибку
            resp.setStatus(500);
            resp.sendError(500,"Too mach");
        }*/

        if (currentParam > 105) {      // бросаем ошибку
            resp.sendRedirect("/here"); // перекинь меня на другую страницу
            Person person = new Person();

        }
    }
}

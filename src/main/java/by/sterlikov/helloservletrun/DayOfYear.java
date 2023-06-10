package by.sterlikov.helloservletrun;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(value = "/year/*")

public class DayOfYear extends HttpServlet {
    private String input;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        input = req.getPathInfo();
        String pattern = "\\d+\\D\\d+\\D\\d+";
        Pattern parr = Pattern.compile(pattern);
        Matcher matcher = parr.matcher(input);
        if(matcher.find()){
            PrintWriter writer = resp.getWriter();
            writer.println("Day of year " + LocalDate.parse(matcher.group()).getDayOfYear());
        }

    }
}

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

@WebServlet(value = "/date/*")
public class DayOfWeekRun extends HttpServlet {
    private String input;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        input = req.getPathInfo();
        PrintWriter writer = resp.getWriter();
        String pattern = "\\d+\\D\\d+\\D\\d+";
        Pattern parr = Pattern.compile(pattern);
        Matcher matcher = parr.matcher(input);
        if (matcher.find()) {
            writer.println("Day of week " + LocalDate.parse(matcher.group()).getDayOfWeek());
        }
    }
}

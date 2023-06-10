package by.sterlikov.helloservletrun;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@WebServlet(value = "/date")
public class DateServletRun extends HttpServlet {
    private final Date currentDate = new Date();
    private final LocalDate date = LocalDate.now();
    private final LocalTime time = LocalTime.now();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(currentDate);
        writer.println("Year " + date.getYear());
        writer.println("Month " + date.getMonth());
        writer.println("Day " + date.getDayOfMonth());
        writer.println("Hour " + time.getHour());
        writer.println("Minute " + time.getMinute());
        writer.println("Second " + time.getSecond());
    }
}

package by.sterlikov.helloservletrun;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = "/third")

public class ThirdServlet extends HttpServlet {
    private Integer value = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //request // для конкретного  запроса
        req.getAttribute("reqAttr");
        req.setAttribute("reqAttr","123");
        req.getAttribute("reqAttr");


        //session/для пользователя пока пользуешься
        value = (Integer)req.getSession().getAttribute("sessAtt") == null ? 0 : (Integer)req.getSession()
                        .getAttribute("sessAtt");
        req.getSession().setAttribute("sessAtt",++value);
        req.getSession().getAttribute("sessAtt");


        // application/для всего приложени
        var appVar = req.getServletContext().getAttribute("appAttr");
        var result = appVar == null ? 0 : (Integer) appVar + 1;
        req.getServletContext().setAttribute("appAttr",result);
    }
}

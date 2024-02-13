package tasks.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.entity.TaskEntity;
import tasks.service.DBManager;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/home")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("taskList", DBManager.findAll());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        LocalDate deadLineDate = LocalDate.parse(req.getParameter("deadLineDate"));
        DBManager.create(new TaskEntity(name, description, deadLineDate));
        resp.sendRedirect("/home");
    }
}

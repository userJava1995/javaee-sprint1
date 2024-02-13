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

@WebServlet("/updateTask")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        LocalDate deadLineDate = LocalDate.parse(request.getParameter("deadLineDate"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));
        DBManager.update(id, new TaskEntity(name, description, deadLineDate, isDone));
        response.sendRedirect("/details?id="+id);
    }
}

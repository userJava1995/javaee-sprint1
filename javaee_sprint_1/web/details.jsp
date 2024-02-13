<%@ page import="tasks.entity.TaskEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="bootstrap/bootstrap.jsp" %>
</head>
<body>
    <%@include file="navbar.jsp" %>

    <%
        TaskEntity task = (TaskEntity) request.getAttribute("task");
    %>

    <div style="display: flex; justify-content: center; width: 700px">
        <form action="/updateTask" method="post" style="width: 100%;">
            <input type="hidden" value="<%=task.getId()%>" name="id">
            <div class="mb-3">
                <label class="form-label">Наименование:</label>
                <input class="form-control" placeholder="Наименование..." name="name" value="<%=task.getName()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Описание:</label>
                <textarea class="form-control" rows="3" name="description"
                          value="<%=task.getDescription()%>">Описание...</textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Крайний срок:</label>
                <input class="form-control" name="deadLineDate" value="<%=task.getDeadLineDate()%>">
            </div>
            <select class="form-select" name="isDone">
                <option selected value="<%=task.isDone()%>"><%=task.isDone()? "Да": "Нет"%></option>
                <option value="<%=!task.isDone()%>"><%=task.isDone()? "Нет": "Да"%></option>
            </select><br>
            <button class="btn btn-primary">Сохранить</button>
            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteTask">
                Delete
            </button>
        </form>
    </div>


    <form action="/deleteTask" method="post">
        <div class="modal fade" id="deleteTask" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel1">Delete Task Modal</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" value="<%=task.getId()%>" name="id">
                        Are you sure you want to delete this task?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button class="btn btn-danger">Delete</button>
                    </div>
                </div>
            </div>
        </div>
    </form>


</body>
</html>

<%@ page import="Java_EE.Spring_Task1.Tasks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
<%@include file="Navbar.jsp"%>
<div class="col-6 mx-auto">
        <%
        Tasks task = (Tasks) request.getAttribute("zadacha");
        if (task != null) {
    %>
    <form action="/task-edit" method="post">
        <input name="task_id" type="hidden" value="<%=task.getId()%>">
        <label>
            <p>Наименование:</p>
            <textarea name="task_name" cols="30" rows="3"
                      class="form-control"><%=task.getName()%></textarea>
        </label><br><br>
        <label>
            <p>Описание:</p>
            <textarea name="task_description" cols="30" rows="3"
                      class="form-control"><%=task.getDescription()%></textarea>
        </label><br><br>
        <label>
            <p>Крайний срок:</p>
            <input name="task_deadlineDate" type="date" value="<%=task.getDeadlineDate()%>"
                   class="form-control">
        </label>
        <label>
            <p>Выпелнено:</p>
            <select class="form-select" name="task_done" aria-label="Default select example">
                <option selected value="Да">Да</option>
                <option value="Нет">Нет</option>
            </select>
        </label>
        <button class="btn btn-success">Сохранить</button>
    </form>


    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
            data-bs-target="#removeTaskModal">
        Удалить
    </button>

    <!-- Modal -->
    <form action="/task-delete" method="post">
        <div class="modal fade" id="removeTaskModal" tabindex="-1"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Вы уверены?</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input name="task_id" type="hidden" value="<%=task.getId()%>">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                            НЕТ
                        </button>
                        <button type="submit" class="btn btn-primary">ДА</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <%
        }
    %>
</div>
</body>
</html>

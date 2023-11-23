<%@ page import="java.util.ArrayList" %>
<%@ page import="Java_EE.Spring_Task1.Tasks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <script type="text/javascript" src="/js/bootstrap.bundle.min.js"></script>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<%@include file="Navbar.jsp"%>

<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    +Добавить задания
</button>

<!-- Modal -->
<form action="/add-task-servlet" method="post">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Новое задание</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                   Наименование: <input name="task_name" type="text" class="form-control mt-1"
                           placeholder="Наименование...">
                    Описание:<input name="task_description" type="text" class="form-control mt-1"
                           placeholder="Описание...">
                    Крайний срок:<input name="task_deadlineDate" type="date" class="form-control mt-1"
                           placeholder="дд/мм/гггг...">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть
                    </button>
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </div>
        </div>
    </div>
</form>

<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Наименование</th>
        <th scope="col">Крайний срок</th>
        <th scope="col">Выполнено</th>
        <th scope="col">Детали</th>
    </tr>
    </thead>
    <tbody class="table-group-divider">
    <%
        ArrayList<Tasks>tasks=(ArrayList<Tasks>) request.getAttribute("zadachi");
        for(Tasks task:tasks){
    %>
    <tr>
        <td><%=task.getId()%></td>
        <td><%=task.getName()%></td>
        <td><%=task.getDeadlineDate()%></td>
        <td><%=task.getDone()%></td>
        <td><a href="task-details?id=<%=task.getId()%>" class="btn btn-dark">Детали</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

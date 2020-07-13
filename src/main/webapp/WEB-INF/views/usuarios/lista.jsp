<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities: Lista Usuários</title>
    </head>
    <body>
        <jsp:include page="../auxiliar/nav.jsp" />
        <h1>Lista de Tarefas</h1>
        <div>${sucesso}</div>
        <table>
            <tr>
                <td>Nome</td>
                <td>Departamento</td
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td>${usuario.nome}</td>
                    <td>${usuario.departamento}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

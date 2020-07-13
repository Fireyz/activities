<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities: Lista Tipos</title>
    </head>
    <body>
        <jsp:include page="../auxiliar/nav.jsp" />
        <h1>Lista de Tipos</h1>
        <div>${sucesso}</div>
        <table>
            <tr>
                <td>Empresa</td>
                <td>Tipo</td>
                <td>Descrição</td>
                <td>Minutos</td>
            </tr>
            <c:forEach items="${tipos}" var="tipo">
                <tr>
                    <td>${tipo.nome}</td>
                    <td>${tipo.departamento}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities: Lista Empresas</title>
    </head>
    <body>
        <jsp:include page="../auxiliar/nav.jsp" />
        <h1>Lista de Empresas</h1>
        <div>${sucesso}</div>
        <table>
            <tr>
                <td>Código</td>
                <td>Filial</td>
                <td>Nome</td>
            </tr>
            <c:forEach items="${empresas}" var="empresa">
                <tr>
                    <td>${empresa.codigo}</td>
                    <td>${empresa.filial}</td>
                    <td>${empresa.nome}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

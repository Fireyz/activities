<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities: Form</title>
    </head>
    <body>
        <jsp:include page="../auxiliar/nav.jsp" />
        <h1>Cadastro de Tipos</h1>
        <form action="/tipos" method="post">
            <div>
                <label for="nome">Nome</label>
                <input type="text" name="nome">
            </div>
            <div>
                <label for="departamento">Departamento</label>
                <select name="departamento_id">
                    <c:forEach items="${departamento}" var="departamentos">
                        <option value="${departamentos.id}">${departamentos.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </body>
</html>

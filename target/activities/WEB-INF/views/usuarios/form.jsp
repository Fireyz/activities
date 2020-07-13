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
        <h1>Cadastro de Usuários</h1>
        <form action="/usuarios" method="post">
            <div>
                <label for="nome">Nome</label>
                <input type="text" name="nome">
            </div>
            <div>
                <label for="departamento">Departamento</label>
                <input type="text" name="departamento">
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </body>
</html>

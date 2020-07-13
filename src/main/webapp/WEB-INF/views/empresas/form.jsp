<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities: Form</title>
    </head>
    <body>
        <jsp:include page="../auxiliar/nav.jsp" />
        <h1>Cadastro de Empresas</h1>
        <form action="/empresas" method="post">
            <div>
                <label>Código</label>
                <input type="text" name="codigo" />
            </div>
            <div>
                <label for="tipo">Filial</label>
                <input type="text" name="filial">
            </div>
            <div>
                <label for="descricao">Nome</label>
                <input type="text" name="nome">            
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </body>
</html>

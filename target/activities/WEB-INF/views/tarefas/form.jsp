<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities: Form</title>
    </head>
    <body>
        <jsp:include page="../auxiliar/nav.jsp" />
        <h1>Cadastro de Tarefas</h1>

        <form:form action="${s:mvcUrl('TarefaController#gravar').build()}" modelAttribute="tarefa" commandName="tarefa" method="POST">
            <div>
                <label>Empresa</label>
                <form:input path="empresa" />
                <form:errors path="empresa" />
            </div>
            <div>
                <label for="tipo">Tipo</label>
                <input type="text" name="tipo">
                <form:errors path="tipo" />
            </div>
            <div>
                <label for="descricao">Descrição</label>
                <textarea rows="10" cols="20" name="descricao"></textarea>
                <form:errors path="descricao" />
            </div>
            <div>
                <label for="minutos">Minutos</label>
                <input type="number" name="minutos">
                <form:errors path="minutos" />
            </div>
            <div>
                <label for="data">Data</label>
                <input name="data">
                <form:errors path="data" />
            </div>
            <button type="submit">Cadastrar</button>
        </form:form>
    </body>
</html>

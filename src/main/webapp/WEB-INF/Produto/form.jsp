<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Cadastro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Produto</h1>
        <h2>Inclusão</h2>
        <div>
            <form method="post" action="${pageContext.request.contextPath}/produto/inclusao">
                <div>
                    <label for="nome">Nome</label>
                    <div>
                        <input type="text" name="nome" id="nome" />
                    </div>
                </div>
                <div>
                    <label>Descrição</label>
                    <div>
                        <textarea name="descricao"></textarea>
                    </div>
                </div>
                <div>
                    <label>Quantidade</label>
                    <div>
                        <input type="text" name="qtd" />
                    </div>
                </div>
                <div>
                    <label>Preço compra</label>
                    <div>
                        <input type="text" name="prcompra" />
                    </div>
                </div>
                <div>
                    <label>Preço venda</label>
                    <div>
                        <input type="text" name="prvenda" />
                    </div>
                </div>
                <fieldset>
                    <legend>Disponível</legend>
                    <input type="radio" value="1" name="disp" id="dispSim" /> <label for="dispSim">Sim</label>
                    <input type="radio" value="0" name="disp" id="dispNao" /> <label for="dispNao">Não</label>
                </fieldset>
                <fieldset>
                    <legend>Categorias</legend>
                    <c:forEach items="${categoria}" var="cat">
                        <input type="checkbox" value="${cat.id}" name="cat" id="cat${cat.nome}" /> <label for="catA"><c:out value="${cat.nome}" /></label>
                    </c:forEach>
                    <!--<input type="checkbox" value="A" name="cat" id="catA" /> <label for="catA">Categoria A</label>
                    <input type="checkbox" value="B" name="cat" id="catB" /> <label for="catB">Categoria B</label>
                    <input type="checkbox" value="C" name="cat" id="catC" /> <label for="catC">Categoria C</label>-->
                </fieldset>
                <button type="submit">Salvar</button>
                <button type="reset">Resetar</button>
            </form>

        </div>
    </body>
</html>
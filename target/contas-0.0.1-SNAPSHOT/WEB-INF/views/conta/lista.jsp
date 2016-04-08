<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contas à pagar/receber</title>
<script src="resources/js/jquery.js"></script>
</head>
<body>
    <table style="height: 10px; width: 775px;" border="1">
        <tr>
        <th>Código</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Tipo</th>
        <th>Paga?</th>
        <th>Data de pagamento</th>
        <th>Ações</th>
        </tr>

        <c:forEach items="${contas}" var="conta">
        <tr>
            <td>${conta.id}</td>
            <td>${conta.descricao}</td>
            <td>${conta.valor}</td>
            <td>${conta.tipo}</td>
            <td id="conta_${conta.id}">
                <c:if test="${conta.paga eq false}">
                    Não paga
                </c:if>
                <c:if test="${conta.paga eq true }">
                    Paga!
                </c:if>
            </td>
            <td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
            <td>
            	<a href="removeConta?id=${conta.id}">Excluir</a>
            	
            	<c:if test="${conta.paga eq false}">
                   | <a href="#" onclick="pagarAgora(${conta.id});">Pagar</a>
                </c:if>
            	
            </td>
        </tr>        
        </c:forEach>
    </table>
    
    <script type="text/javascript">
    
    	function deuCerto(DadosDaResposta) {
    		alert("Conta paga com sucesso!");
    	}
    
    	function pagarAgora(id) {
    		//$.get("pagarConta?id="+id, deuCerto);
    		$.post("pagarConta", {'id' : id}, function() {
  			  $("#conta_"+id).html("Paga");
  			});
    	}
    </script>
    
</body>
</html>
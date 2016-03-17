<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
 <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</head>
<body style="padding: 30px;">
	<h1>EAD - Pre Cadastro </h1>

	<form:form method="GET" commandName="pessoa" action="/" id="form">
		
	<div class="row">	
	 <div class="col-xs-4">
		<label>Nome:</label>
		<form:input path="nome" cssClass="form-control input-sm" maxlength="200"/>
			
		<label>Email:</label>
		<form:input path="email"  cssClass="form-control input-sm" maxlength="200" />
			
		<br>
		<label>Sexo:</label>
		<div class="checkbox" >
			<form:radiobuttons path="sexo" items="${sexo}" />		
		</div>
		
		
		<label>Gradução:</label>
		<form:select path="graduacao" items="${graduacao}" class="form-control">
		</form:select>
	
		
		
		<div class="radio" >
			<form:checkbox path="formado"  />	
			<label>Ja possui graduação ou se formara nos proximos 6 meses?:</label>	
		</div>
		<br>
		<button type="button" onclick="enviar();"  class="btn btn-primary btn-sm" >Salvar</button>
	</div>
	</div>	
		
		
		
	<div id="lista" class="row">
	<br></br>
	
		<c:if test="${lstPessoas.size() > 0}">
		<label>Exibe o Cadastro no Banco de Dados</label>
			<table class="table table-striped">
						 <tr>
						   <td>#</td>
						   <td>Nome</td>
						   <td>Email</td>
					       <td>Sexo</td>
					       <td>Formado</td>
					       <td>Graduação Escolhida</td>
					       <td>#</td>
					       
						 </tr>
							<c:forEach var="p" items="${lstPessoas}">
						<tr>
						   <td><c:out value="${p.idPessoa}" /></td>
						   <td><c:out value="${p.nome}" /></td>
						   <td><c:out value="${p.email}" /></td>
						   <td><c:out value="${p.sexo}" /></td>
						   <td><c:out value="${p.formado}" /></td>
						   <td><c:out value="${p.graduacao}" /></td>
						   <td><button type="button" onclick="deletar( ${p.idPessoa}  );" class="btn btn-danger" >Excluir</button></td>
						</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	</form:form>	
		
	
	

	
	
	
	
	
	
<script>
function enviar(){
	var str = $("#form").serialize();
	
	$.ajax({
	    type:"get",
	    data:str,
	    url:"/fiveware-test-web/addPessoa",
	    async: true,
	    dataType: "json",
	    complete: function(xhr, textStatus) {
	    	if(xhr.status == 200){
	    		alert("Salvo com sucesso!");
	    		 $( "#lista" ).load(window.location.href + " #lista" );
	    	}else{
	    		alert("Erro ao salvar!");
	    	}
	    }
	
	});
	
}



function deletar(id){
	var str = "id="+id;
	
	$.ajax({
	    type:"get",
	    data:str,
	    url:"/fiveware-test-web/deletar",
	    async: true,
	    dataType: "json",
	    complete: function(xhr, textStatus) {
	    	if(xhr.status == 200){
	    		alert("Excluido com sucesso!");
	    		 $( "#lista" ).load(window.location.href + " #lista" );
	    	}else{
	    		alert("Erro ao salvar!");
	    	}
	    }
	
	});
	
}
</script>
</body>
</html>
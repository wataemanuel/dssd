<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<!-- Bootstrap CSS -->
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="resources/bootstrap/css/estilo.css" rel="stylesheet">
<!-- Bootstrap JS -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>SSA - Incidente</title>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
		  <li class="active"><a href="home">Inicio</a></li>
		  <li><a href="#">Información</a></li>
		  <li><a href="#">Contacto</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="btn btn-primary" href="logout">SALIR</a></li>
		</ul>
	</div>
</nav>
<br>
<div class="container">
    <div class="panel panel-success">
        <div class="panel-heading">
			<h3 align="left">Incidente</h3>
		</div>
	<div class="panel-body">		
			<form:form id="incidenteRegisterForm" class="form-horizontal" action="guardarIncidente" modelAttribute="incidenteForm">
			<form:hidden path="id"  value="${incidenteForm.id}" />
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="fechaIncidente">Fecha</form:label>	
				<form:input path="fechaIncidente" id="datepicker" size="30" />
				<form:errors path="fechaIncidente" cssClass="error"/>
			</div>
			<div id="errorF" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="descripcion">Descripción del incidente</form:label>	
				<form:input path="descripcion" size="80" />
				<form:errors path="descripcion" cssClass="error"/>
			</div>
			<div id="errorD" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="tipoIncidente.id">Tipo de Incidente</form:label>
				<form:select id="tipoInci" path="tipoIncidente.id" >
				<form:option value="0">--Seleccione</form:option>
					<c:forEach items="${tipoIncidenteList}" var="tipoIncidente">
	   					<form:option value="${tipoIncidente.id}"
	   					label="${tipoIncidente.descripcion}" />
	                </c:forEach>
				</form:select>
				<form:errors path="tipoIncidente.id" cssClass="error"/>
			</div>
			<div id="errorT" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			
			<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-success" type="submit" value="Cargar incidencia"/>
			</div>	
			</div>
			</form:form>
	    	</div>
  		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	 $(function() {
	    	$("#datepicker").datepicker({maxDate: 0});
	    });
	$("#errorF").hide();
	$("#errorD").hide();
	$("#errorT").hide();
	$("#incidenteRegisterForm").submit(function () {  
	    if($("#fecha").val().length < 1) {  
	    	$("#errorF").show(); 
	    	$("#errorF").hide(7000);
	    	$("#errorF").hide("fast");
	        return false;  
	    }
	    return true;  
	});
	$("#incidenteRegisterForm").submit(function () {  
	    if($("#descripcion").val().length < 1) {  
	    	$("#errorD").show(); 
	    	$("#errorD").hide(7000);
	    	$("#errorD").hide("fast");
	        return false;  
	    }
	    return true;  
	});
	$("#incidenteRegisterForm").submit(function () {  
	    if($("#tipoInci").val() == 0) {  
	    	$("#errorT").show(); 
	    	$("#errorT").hide(7000);
	    	$("#errorT").hide("fast");
	        return false;  
	    }
	    return true;  
	});
});
</script>
</html>
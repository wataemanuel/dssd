<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

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
<script src="resources/js/jquery-ui.js"></script>
<link rel="stylesheet" href="resources/js/jquery-ui.css">

<title>SSA - Incidentes</title>
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
			<h3 align="left">Incidentes</h3>
		</div>
		<div class="panel-body">		
			<c:if test="${empty incidenteList}">
                No hay Incidentes
            </c:if>
            <c:if test="${not empty incidenteList}">
                <table class="table table-hover table-bordered table-responsive">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Nº de expediente</th>
                        <th>Fecha de incidente</th>
                        <th>Tipo</th>
                        <th>Descripcion del incidente</th>
                        <th>Fecha de registro</th>
                        <th>Estado</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${incidenteList}" var="incident">
                    <tr>
						<td><c:out value="${incident.id}" /></td>
						<c:set var="inci" value="${incident.fechaIncidente}"/>
						<td><c:out value="${fn:substringBefore(inci, ' ')}" /></td>
						<td><c:out value="${incident.tipoIncidente.descripcion}" /></td>
						<td><c:out value="${incident.descripcion}" /></td>
						<c:set var="expe" value="${incident.fechaExpediente}"/>
						<td><c:out value="${fn:substringBefore(expe, '.')}" /></td>
						<td><c:out value="${incident.estado.estado}" /></td>
					</tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
	   	</div>
	</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#datepicker").datepicker({maxDate: 0});
	$("#errorF").hide();
	$("#errorD").hide();
	$("#errorT").hide();
	$("#incidenteRegisterForm").submit(function() {  
	    if($("#fecha").val().length < 1) {
	    	$("#errorF").show(); 
	    	$("#errorF").hide(7000);
	    	$("#errorF").hide("fast");
	        return false;  
	    }
	    if($("#descripcion").val().length < 1) {
	    	$("#errorD").show(); 
	    	$("#errorD").hide(7000);
	    	$("#errorD").hide("fast");
	        return false;  
	    }
	    if($("#tipoInci").val() < 1) {
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  


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
<title>SSA - Registro</title>
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
			<li><a class="btn btn-primary" href="login">ENTRAR</a></li>	
		</ul>
	</div>
</nav>
<br>
<div class="container">
    <div class="panel panel-success">
        <div class="panel-heading">
			<h3 align="left">Registro</h3>
		</div>
	<div class="panel-body">		
			<form:form id="usuarioRegisterForm" class="form-horizontal" action="guardarUsuario" modelAttribute="usuarioForm">
			<form:hidden path="id"  value="${usuarioForm.id}" />
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="nombre">Nombre</form:label>	
				<form:input path="nombre" size="30" />
				<form:errors path="nombre" cssClass="error"/>
			</div>
			<div id="errorNOM" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="apellido">Apellido</form:label>	
				<form:input path="apellido" size="30" />
				<form:errors path="apellido" cssClass="error"/>
			</div>
			<div id="errorAP" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="dni">DNI</form:label>
				<form:input id="dni" path="dni" size="30"/>
				<form:errors path="dni" cssClass="error"/>
			</div>
			<div id="errorDni" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div id="errorDniE" class="alert alert-danger">
  				<strong>Error!</strong> Este DNI ya está registrado.
			</div>
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="email">Email</form:label>
				<form:input id="email" path="email" size="30"/>
				<form:errors path="email" cssClass="error"/>
			</div>
			<div id="errorE" class="alert alert-danger">
 				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div id="errorEm" class="alert alert-danger">
  				<strong>Error!</strong> Este correo electrónico ya está registrado.
			</div>
			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="password">Password</form:label>
				<form:password id="password" path="password" showPassword="true" size="30"/>
				<form:errors path="password" cssClass="error"/>
			</div>
			<div id="errorP" class="alert alert-danger">
				<strong>Error!</strong> Campo obligatorio.
			</div>
			<div id="errorPa" class="alert alert-danger">
				<strong>Error!</strong> La contraseña debe tener al menos 6 caracteres.
			</div>
			<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input class="btn btn-success" type="submit" value="Guardar"/>
			</div>	
			</div>
			</form:form>
	    	</div>
  		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#errorNOM").hide();
	$("#errorAP").hide();
	$("#errorP").hide();
	$("#errorPa").hide();
	$("#errorE").hide();
	$("#errorEm").hide();
	$("#errorDni").hide();
	$("#errorDniE").hide();
	$("#usuarioRegisterForm").submit(function () {  
	    if($("#dni").val().length < 1) {  
	    	$("#errorDni").show(); 
	    	$("#errorDni").hide(7000);
	    	$("#errorDni").hide("fast");
	        return false;  
	    }else {
	    	var si;
	    	$.ajax({url: './controlarDNI',
		        type: 'GET',
		        async: false,
		        data: { dni:$("#dni").val(), id:$("#id").val() },
		        success: function(data){
		        	 data = jQuery.parseJSON(data);
		        	 if (data.resultado == "encontro"){
		        		 si = true;
		        	 } else {
		        		 si = false;
		        	 }
		        }	   
		      });
	    	if(si){
        		$("#errorDniE").show();
 	    		$("#errorDniE").hide(7000);
      	    	$("#errorDniE").hide("fast");
      	    	return false;
 	    	 }
 	    	 return true; 
	    }   
	});
	$("#usuarioRegisterForm").submit(function () {  
	    if($("#email").val().length < 1) {  
	    	$("#errorE").show(); 
	    	$("#errorE").hide(7000);
	    	$("#errorE").hide("fast");
	        return false;  
	    } else {
	    	var si;
	    	$.ajax({url: './controlarEmail',
		        type: 'GET',
		        async: false,
		        data: { email:$("#email").val(), id:$("#id").val() },
		        success: function(data){
		        	 data = jQuery.parseJSON(data);
		        	 if (data.resultado == "encontro"){
		        		 si = true;
		        	 } else {
		        		 si = false;
		        	 }
		        }	   
		      });
	    	if(si){
        		$("#errorEm").show();
 	    		$("#errorEm").hide(7000);
      	    	$("#errorEm").hide("fast");
      	    	return false;
 	    	 }
 	    	 return true; 
	    }  
	});
	$("#usuarioRegisterForm").submit(function () {  
	    if($("#password").val().length < 1) {  
	    	$("#errorP").show(); 
	    	$("#errorP").hide(7000);
	    	$("#errorP").hide("fast");
	        return false;  
	    } else {
	    	if($("#password").val().length < 6) {  
		    	$("#errorPa").show(); 
		    	$("#errorPa").hide(7000);
		    	$("#errorPa").hide("fast");
		        return false;  
		    }  
	    }
	    return true;  
	});
	$("#usuarioRegisterForm").submit(function () {  
	    if($("#apellido").val().length < 1) {  
	    	$("#errorAP").show(); 
	    	$("#errorAP").hide(7000);
	    	$("#errorAP").hide("fast");
	        return false;  
	    }
	    return true;  
	});
	$("#usuarioRegisterForm").submit(function () {  
	    if($("#nombre").val().length < 1) {  
	    	$("#errorNOM").show(); 
	    	$("#errorNOM").hide(7000);
	    	$("#errorNOM").hide("fast");
	        return false;  
	    }
	    return true;  
	});
});
</script>
</html>
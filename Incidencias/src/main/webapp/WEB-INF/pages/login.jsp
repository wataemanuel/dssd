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
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/bootstrap/css/login.css" rel="stylesheet">
<!-- Bootstrap JS -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<title>SSA - Login</title>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
		  <li class="active"><a href="home">Inicio</a></li>
		  <li><a href="#">Información</a></li>
		  <li><a href="#">Contacto</a></li>
		</ul>
	</div>
</nav>
	<div class="container">
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form:form id ="loginForm" action="login" modelAttribute="usuarioForm" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <form:input path="email" size="30" class="form-control" placeholder="email@adress.com" />
                
			<div id="errorM" class="alert alert-danger">
 				<strong>Campo obligatorio.</strong>
			</div>
                <form:password path="password" size="30" class="form-control" placeholder="Password" />
                
			<div id="errorP" class="alert alert-danger">
 				<strong>Campo obligatorio.</strong>
			</div>
                <c:if test="${!empty mensaje }"> 
                <div class="alert alert-danger">
  					<strong>Error!</strong> Email/Password incorrecto
				</div>
				</c:if>
                <input class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="ENTRAR"/>
            </form:form><!-- /form -->
            <br>
			<p align=center><a href="altaUsuario">¿No tienes cuenta? Regístrate</a></p>
        </div><!-- /card-container -->
	</div><!-- /container -->
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#errorM").hide();
	$("#errorP").hide();
	$("#loginForm").submit(function () {  
	    if($("#email").val().length < 1) {  
	    	$("#errorM").show(); 
	    	$("#errorM").hide(7000);
	    	$("#errorM").hide("fast");
	        return false;  
	    }
	    return true;  
	});
	$("#loginForm").submit(function () {  
	    if($("#password").val().length < 1) {  
	    	$("#errorP").show(); 
	    	$("#errorP").hide(7000);
	    	$("#errorP").hide("fast");
	        return false;  
	    }
	    return true;  
	});
});
</script>
</html>
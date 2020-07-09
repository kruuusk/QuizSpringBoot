<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risposta Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/quiz/saveRisposta" var="saveURL" />
		<h2>Answer</h2>
		<form:form modelAttribute="rispostaForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<label>Text</label>
				<form:input path="testo" cssClass="form-control" id="text" />
			</div>
			<div class="form-group">
				<label>Right</label>
				<form:input path="corretto" cssClass="form-control" id="right" />
			</div>
			<div class="form-group">
				<label>Question ID</label>
				<form:input path="domanda.id" cssClass="form-control" id="questionId" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>

	</div>
</body>
</html>
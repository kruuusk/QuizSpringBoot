<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Domanda Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/quiz/saveDomanda" var="saveURL" />
		<h2>Quiz</h2>
		<div class="form-group">
			<label><b>ID:</b></label> ${quizDetail.id}
		</div>
		<div class="form-group">
			<label><b>Title:</b></label> ${quizDetail.titolo}
		</div>
		<div class="form-group">
			<label><b>Time:</b></label> ${quizDetail.tempo}
		</div>
		<div class="form-group">
			<label><b>Author:</b></label> ${quizDetail.codice_autore}
		</div>
		<h2>Question</h2>
		<div class="form-group">
			<label><b>ID:</b></label> ${domandaDetail.id}
		</div>
		<div class="form-group">
			<label><b>Text:</b></label> ${domandaDetail.testo}
		</div>
		<div class="form-group">
			<label><b>Quiz ID:</b></label> ${domandaDetail.quiz.id}
		</div>
		<h2>Answer List</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Text</th>
				<th scope="row">Right</th>
				<th scope="row">Answer ID</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
				<th scope="row">Show</th>
			</thead>
			<tbody>
				<c:forEach items="${rispostaList }" var="risposta">
					<tr>
						<td>${risposta.id }</td>
						<td>${risposta.testo }</td>
						<td>${risposta.corretto }</td>
						<td>${risposta.domanda.id }</td>
						<td><spring:url value="/quiz/updateRisposta/${risposta.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url value="/quiz/deleteRisposta/${risposta.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>
						<td><spring:url value="/quiz/showRisposta/${risposta.id }"
								var="showURL" /> <a class="btn btn-primary"
							href="${showURL }" role="button">Show</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/quiz/addRisposta/${domandaDetail.id}" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add
			New Answer</a>
		
		<spring:url value="/quiz/showQuiz/${quizDetail.id}" var="listURL" />
		<a class="btn btn-primary" href="${listURL }" role="button">Back</a>

	</div>
</body>
</html>
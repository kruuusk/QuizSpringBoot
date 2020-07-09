<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Form</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/quiz/saveQuiz" var="saveURL" />
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
		<h2>Question List</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Text</th>
				<th scope="row">Quiz ID</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
				<th scope="row">Show</th>
			</thead>
			<tbody>
				<c:forEach items="${domandaList }" var="domanda">
					<tr>
						<td>${domanda.id }</td>
						<td>${domanda.testo }</td>
						<td>${domanda.quiz.id }</td>
						<td><spring:url value="/quiz/updateDomanda/${domanda.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url value="/quiz/deleteDomanda/${domanda.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>
						<td><spring:url value="/quiz/showDomanda/${domanda.id }"
								var="showURL" /> <a class="btn btn-primary"
							href="${showURL }" role="button">Show</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/quiz/addDomanda/${quizDetail.id}" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add
			New Question</a>
		
		<spring:url value="/quiz/list/" var="listURL" />
		<a class="btn btn-primary" href="${listURL }" role="button">Back</a>

	</div>
</body>
</html>
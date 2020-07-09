<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz List</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Quiz List</h2>
		<table class="table table-striped">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Title</th>
				<th scope="row">Time</th>
				<th scope="row">Author</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
				<th scope="row">Show</th>
				<th scope="row">Start</th>
			</thead>
			<tbody>
				<c:forEach items="${quizList }" var="quiz">
					<tr>
						<td>${quiz.id }</td>
						<td>${quiz.titolo }</td>
						<td>${quiz.tempo }</td>
						<td>${quiz.codice_autore }</td>
						<td><spring:url value="/quiz/updateQuiz/${quiz.id }"
								var="updateURL" /> <a class="btn btn-primary"
							href="${updateURL }" role="button">Update</a></td>
						<td><spring:url value="/quiz/deleteQuiz/${quiz.id }"
								var="deleteURL" /> <a class="btn btn-primary"
							href="${deleteURL }" role="button">Delete</a></td>
						<td><spring:url value="/quiz/showQuiz/${quiz.id }"
								var="showURL" /> <a class="btn btn-primary"
							href="${showURL }" role="button">Show</a></td>
						<td><spring:url value="/quiz/startQuiz/${quiz.id }"
								var="showURL" /> <a class="btn btn-primary"
							href="${showURL }" role="button">Start</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/quiz/addQuiz/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add
			New Quiz</a>
	</div>
</body>
</html>
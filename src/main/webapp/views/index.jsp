<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
		<h3 class="pb-6 pt-3">Report Application</h3>
		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>plan name:</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${names}" />
						</form:select></td>
					<td>plan status:</td>
					<td><form:select path="planStatus">
							<form:option value="">--select</form:option>
							<form:options items="${status}" />
						</form:select></td>
					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">--select--</form:option>
							<form:option value="male">--male--</form:option>
							<form:option value="female">--female--</form:option>
						</form:select></td>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date"
							data-date-format="dd/MM/yyyy" />
					<td>endDate:</td>
					<td><form:input type="date" path="endDate" /></td>
				</tr>
				<tr>
			<td><a href="/" class="btn btn-secondary"> Reset</a></td>
					<td><input type="submit" value="search"
				class="btn btn-primary" /></td>
				</tr>
			</table>
		</form:form>
		<hr />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>HolderName</th>
					<th>Plan name</th>
					<th>gender</th>
					<th>Plan Status</th>
					<th>Start date</th>
					<th>End date</th>
					<th>Benefit Amt</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.planName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEnddate}</td>
						<td>${plan.benefitAmt}</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty plans }">
				<td colspan="8" style="text-align:center">No Records Found</td>
				</c:if>
				</tr>
			</tbody>
		</table>
		<hr />
		Export:<a href="excel">excel</a><a href="Pdf">pdf</a>
	</div>
	<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
crossorigin="anonymous"></script>

</body>
</html>
</body>
</html>
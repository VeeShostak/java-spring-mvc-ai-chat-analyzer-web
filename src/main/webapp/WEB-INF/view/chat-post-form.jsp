<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save ChatPost</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-chat-post-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Ai Chat Analyzer</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Chat Post</h3>
	
		<form:form action="saveChatPost" modelAttribute="chatPost" method="POST">
		<!-- display the chatPost model info we passed from controller. on click submit go to /saveChatPost-->

			<!-- need to associate this data with chatPost id -->
			<!-- (calls (setId/getId, getUserQuery, setUserQuery, etc) accordingly) -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
				
				
					<tr>
						<td><label>User Query:</label></td>
						<td><form:input type="text" path="userQuery" /></td>
					</tr>
				
					<tr>
						<td><label>Response:</label></td>
						<td><form:input type="text" path="response" /></td>
					</tr>

					<tr>
						<td><label>Machine Responded:</label></td>
						<td><form:checkbox path="machineResponded" /></td>
					</tr>
					
					 <tr>
						<td><label>Created At:</label></td>
						<td><form:input path="createdAt" /></td>
					</tr>
					
					<tr>
						<td><label>User Id:</label></td>
						<td><form:input path="userId.uid" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		
		
		</form:form>
	
		<!-- option to take user back to the list -->
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/chat-post/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>











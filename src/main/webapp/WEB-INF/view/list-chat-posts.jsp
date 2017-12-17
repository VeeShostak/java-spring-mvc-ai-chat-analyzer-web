 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  for spring forms tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List ChatPosts</title>
	<!-- reference style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Ai Chat Analyzer</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- button to add a chatPosts (calls our spring controller mapping (showFormForAdd)) -->
			<!-- <input type="button" value="Add ChatPost"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/> -->
			
			<!--  search box -->
            <form:form action="search" method="POST">
                Search chat post: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
			<table>
				<tr>
					<th>User Query</th>
					<th>Response</th>
					<th>Machine Responded</th>
					<th>Created At</th>
					<th>User Id</th>
					<th>Action</th>
				</tr>
				
				<!-- print chat posts using loop. access the Model "chatPosts" given from ChatPostsController-->
				<c:forEach var="tempChatPost" items="${chatPosts}">
				

					<!-- generate an update link with chatPost id  -->
					<c:url var="updateLink" value="/chat-post/showFormForUpdate">
						<c:param name="chatPostId" value="${tempChatPost.id}" />
					</c:url>	
					

					<!-- generate a delete link with chatPost id-->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="chatPostId" value="${tempChatPost.id}" />
					</c:url>		
					
					<tr>
						<td> ${tempChatPost.userQuery} </td>
						<td> ${tempChatPost.response} </td>
						<td> ${tempChatPost.machineResponded} </td>
						<td> ${tempChatPost.createdAt} </td>
						<td> ${tempChatPost.userId.uid} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- added javascript to promt the user -->
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this chat post?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
			</table>
				
		</div>
	</div>
	
	
</body>

</html>




 
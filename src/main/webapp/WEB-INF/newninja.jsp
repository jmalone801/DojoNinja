<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        
        <h1>New Ninja</h1>
        
        <form:form action="/newninja" method="post" modelAttribute="ninjas">
	       	<form:label path ="dojo">Dojo: </form:label>
	       	<form:errors path="dojo"/>
	       	
	       	<form:select path="dojo">
	        	<c:forEach var="i" items="${dojos}">
	        		<form:option value="${i.id}"> 
		        		<c:out value="${i.name}"></c:out>
	        		</form:option>	
	        	</c:forEach>
			</form:select>
			
			<form:label path ="firstName">First Name: </form:label>
	       	<form:errors path="firstName"/>
	       	<form:input path="firstName"/>
	       	
	       	<form:label path ="lastName">Last Name: </form:label>
	       	<form:errors path="lastName"/>
	       	<form:input path="lastName"/>
	       	
	       	<form:label path ="age">Age: </form:label>
	       	<form:errors path="age"/>
	       	<form:input type="number" path="age"/>
	       	
	       	<input type="submit" value="Submit"/>
        	
        </form:form>
        
		
        	
    </div> <!-- End of Container -->
</body>
</html>
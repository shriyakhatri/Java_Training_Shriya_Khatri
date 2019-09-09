<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="registeradd" method="POST" modelAttribute="user">
  <div class="container">
   <div style="color:red">
<h2>
<form:errors path="username"> </form:errors>
<form:errors path="password"> </form:errors>
<%-- <form:errors path="address"> </form:errors>
<form:errors path="password"> </form:errors> --%>
</h2>
</div>
    <p>Please fill in the given details .</p>
    <hr>

    <label for="username"><b>Name:</b></label>
    <form:input type="text" placeholder="Enter name" name="username" required="true" path="username"/>
<br><br>

    <label for="contact_no"><b>Contact No:</b></label>
    <form:input type="text" placeholder="Enter contact number" name="contact_no" path="contact_no" required="true" />
 <br><br>
  
    <label for="address"><b>Address</b></label>
    <form:input type="text" placeholder="Enter address" name="address" path="address" required="true"/>
  <br><br>
  
   <label for="password"><b>Password</b></label>
    <form:input type="password" placeholder="Enter password" name="password" path="password" required="password"/>
  <br><br>
  
  
    <hr>
   
    <input type="submit" class="addbt" value="register"/>
  </div>
 
  
</form:form>

 
 </body>
 </html>



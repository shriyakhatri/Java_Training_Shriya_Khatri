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

<form:form action="addproduct" method="POST" modelAttribute="product">
  <div class="container">
   <div style="color:red">
<h2>
<form:errors path="name"> </form:errors>
<form:errors path="description"> </form:errors>
<form:errors path="price"> </form:errors>
<form:errors path="quantity"> </form:errors>
<form:errors path="discount"> </form:errors>
</h2>
</div>
    <p>Please fill in the given details .</p>
    <hr>

    <label for="name"><b>Name:</b></label>
    <form:input type="text" placeholder="Enter name" name="name" required="true" path="name"/>
<br><br>

    <label for="mobile"><b>Description:</b></label>
    <form:input type="text" placeholder="Enter Mobile description" name="description" path="description" required="true" />
 <br><br>
  
    <label for="price"><b>Price</b></label>
    <form:input type="text" placeholder="Enter Price" name="price" path="price" required="true"/>
  <br><br>
  
   <label for="quantity"><b>Quantity</b></label>
    <form:input type="text" placeholder="Enter quantity" name="quantity" path="quantity" required="quantity"/>
  <br><br>
  
  <label for="discount"><b>Discount</b></label>
    <form:input type="text" placeholder="Enter discount" name="discount" path="discount" required="discount"/>
  <br><br>
    <hr>
   
    <input type="submit" class="addbt" value="add"/>
  </div>
 
  
</form:form>

 
 </body>
 </html>
















</body>
</html>
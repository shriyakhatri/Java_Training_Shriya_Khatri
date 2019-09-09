<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
 <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
  border-collapse: collapse;
  width: 60%;
}

th, td {
  text-align: center;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: pink;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Your cart!!</h1>
<table align="center">
  <tr>
         <td><strong>Name</strong></td>
         <td><strong>Description</strong></td>
         <td><strong>Discount</strong></td> 
         <td><strong>Price</strong></td> 
         <td><strong>Quantity</strong></td> 
        
         
           
       </tr>
 
 <c:forEach items="${pro}" var="p">
 
   <tr>
         
         <td>${p.name}</td>
         <td>${p.description}</td>
         <td>${p.discount}</td> 
         <td>${p.price}</td> 
         <td>${p.quantity}</td> 
         
     </tr>
        
 <td> 
 </c:forEach>
<br/>
    <br>


</table>
<form method="post" action="display">
         <button type="submit">continue shopping</button>
 </form>
 <br><br>
 <form method="post" action="checkout">
         <button type="submit">checkout</button>
 </form>

</body>
</html>
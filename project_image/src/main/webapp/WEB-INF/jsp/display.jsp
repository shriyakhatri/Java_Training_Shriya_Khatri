<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<h1>all products</h1>
<table align="center">
  <tr>
         <td><strong>Name</strong></td>
         <td><strong>Description</strong></td>
         <td><strong>Discount</strong></td> 
         <td><strong>Price</strong></td> 
         <td><strong>Quantity</strong></td> 
         <td><strong>Add to cart</strong></td> 
         
           
       </tr>
 
 <c:forEach items="${products}" var="pro">
 
   <tr>
         
         <td>${pro.name}</td>
         <td>${pro.description}</td>
         <td>${pro.discount}</td> 
         <td>${pro.price}</td> 
         <td>${pro.quantity}</td> 
         
         
         
         <td> 
              
              <%-- <input type="checkbox" name="add to cart" value="${pro.id}"> --%>
              
          <%-- <input type="submit" id=${pro.id} onclick="myFunction()"class="addbt" name="cart" value="${pro.id}" /> --%>
          
         
          </td>
         
    <!--   <form method="post" action="cart">   -->  
          <td> 
          <a href="cart?id=${pro.id}&name=${pro.name}&description=${pro.description}&discount=${pro.discount}&price=${pro.price}&quantity=${pro.quantity}"> 
          <button>Add to Cart</button>
          
          <%-- <input type="button" class="addbt" name="cart" value="${pro.id}" href=cart?id=${pro.id} /> --%></td> 
               <c:set var="id" value= "${pro.id}" scope="session"  /> 
    <!--   </form>  -->
           
       </tr>
   
   
   <%--  ${pro}; --%>
    <br/>
    <br>
</c:forEach>

</table>

 

</body>
</html>
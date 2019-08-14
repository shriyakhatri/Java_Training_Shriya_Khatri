<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>





<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Mobile Application</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="login.jsp">Logout</a></li>
    </ul>
  </div>
</nav>




<form action="add.do" method="post">
  Mobile id:
  <input type="text" name="id"  required>
  <br><br>
  Mobile name:
  <input type="text" name="name"  required>
  <br><br>
   Mobile description:
  <input type="text" name="descripton"  required>
  <br><br>
    Mobile Price:
  <input type="text" name="descripton"  required>
  <br><br>
  <input type="submit" value="submit">
</form>


</body>
</html>
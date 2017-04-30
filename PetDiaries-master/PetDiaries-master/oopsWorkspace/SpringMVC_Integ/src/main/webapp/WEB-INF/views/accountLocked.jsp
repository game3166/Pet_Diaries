<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>!!Account locked!!</title>
</head>
<body>
   <p>!!!ACCOUNT LOCKED!!!</p>
	<p>More than three incorrect attempts have been made to login. Account has been locked! </p> 
	<p>Reset password by going back to login screen and clicking "Forgot username/password"</p>
   <form:form method = "GET" action = "/SpringMVC/login">
         <table>
            <tr>
            <td>Go back to login</td>
               <td>
                   <td><a href="login">Login</a>
               </td>
            </tr>
         </table>  
      </form:form>
      
   <form:form method = "GET" action = "/SpringMVC/redirect">
         <table>
            <tr>
            <td>Sign up for a new account</td>
               <td>
                  <!--  <input type = "submit" value = "Sign Up"/>-->
                   <td><a href="redirect">Sign Up</a>
               </td>
            </tr>
         </table>  
      </form:form>

</body>
</html>
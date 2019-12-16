<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>

		<h1>Enter the city name </h1>
       <form:form method="post" action="save">
      	<table >
            <form:hidden path="id" />
         <tr>  
          <td>Name : </td> 
          <td><form:input path="city" /></td>
         </tr>  

         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Check the weather" /></td>
         </tr>  
        </table>  
       </form:form>  

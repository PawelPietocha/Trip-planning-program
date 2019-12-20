<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <meta charset="UTF-8">
</head>
<h1>Enter the city name </h1>
<form:form method="post" action="saveDescription">
    <table >
        <form:hidden path="id" />
        <tr>
            <td>City : </td>
            <td><form:input path="city" /></td>
        </tr>


        <tr>
            <td> </td>
            <td><input type="submit" value="Check the description" /></td>
        </tr>
    </table>
</form:form>

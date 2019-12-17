<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="/WEB-INF/css/style.css"%></style>

<h1>Enter two cities names to check distance between them </h1>
<head>
    <meta charset="UTF-8">
</head>
<form:form method="post" action="saveDistance">
    <table >
        <form:hidden path="id" />
        <tr>
            <td>City1 : </td>
            <td><form:input path="city1" /></td>
        </tr>
        <tr>
            <td>City2 :</td>
            <td><form:input path="city2" /></td>
        </tr>


        <tr>
            <td> </td>
            <td><input type="submit" value="Check distance" /></td>
        </tr>
    </table>
</form:form>

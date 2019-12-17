<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
</head>
<h1>Database</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>City</th>
        <th>Province</th>

    </tr>
    <c:forEach var="pCity" items="${list3}">
        <tr>
            <td>${pCity.id}</td>
            <td>${pCity.city}</td>
            <td>${pCity.province}</td>
        </tr>
    </c:forEach>
</table>

<td>
    <form:form method="post" action="BackToChoice">
        <input type="submit" class="button" name="BackToChoice" value="Return to the start screen"/>
    </form:form>
</td>
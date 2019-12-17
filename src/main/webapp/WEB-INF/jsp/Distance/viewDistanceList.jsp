<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
</head>
<h1>Previous distance searches</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>City1</th>
        <th>City2</th>
        <th>Distance</th>

    </tr>
    <c:forEach var="distance" items="${list4}">
        <tr>
            <td>${distance.id}</td>
            <td>${distance.city1}</td>
            <td>${distance.city2}</td>
            <td>${distance.distance}</td>
        </tr>
    </c:forEach>
</table>

<td>
    <form:form method="post" action="BackToChoice">
        <input type="submit" class="button" name="BackToChoice" value="Return to the start screen"/>
    </form:form>
</td>
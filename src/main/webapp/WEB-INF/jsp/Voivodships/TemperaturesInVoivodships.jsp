<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
</head>
<h1>Database</h1>
<table border="2" width="50%" cellpadding="2">
    <tr>
        <th>City</th>
        <th>Temperature</th>
    </tr>
    <c:forEach var="voivodship" items="${list2}">
        <tr>
    <td>${voivodship.name}</td>
    <td>${voivodship.temp}</td>

        </tr>
    </c:forEach>
</table>

<td>
    <form:form method="post" action="BackToChoice">
        <input type="submit" class="button" name="BackToChoice" value="Return to the start screen"/>
    </form:form>
</td>
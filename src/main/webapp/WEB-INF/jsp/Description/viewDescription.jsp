<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
</head>
<h1>Distance</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>City</th>
        <th>Homepage</th>
        <th>Population</th>
        <th>Description</th>


    </tr>
    <c:forEach var="description" items="${list5}">
        <tr>
            <td>${description.id}</td>
            <td>${description.city}</td>
            <td>${description.homepage}</td>
            <td>${description.population}</td>




        </tr>
    </c:forEach>
</table>

<td>
    <form:form method="post" action="BackToChoice">
        <input type="submit" class="button" name="BackToChoice" value="Return to the start screen"/>
    </form:form>
</td>
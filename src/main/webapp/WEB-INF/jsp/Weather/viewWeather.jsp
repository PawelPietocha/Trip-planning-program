<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
</head>
<h1>Your search</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>City</th>
        <th>Temperature</th>
        <th>Humidity (%)</th>
        <th>Clouds (%)</th>
        <th>Pressure (hPa)</th>
        <th>Weather Description</th>
        <th>Date of entry</th>
    </tr>
    <c:forEach var="we" items="${list}">
    <tr>
        <td>${we.id}</td>
        <td>${we.city}</td>
        <td>${we.temperature}</td>
        <td>${we.humidity}</td>
        <td>${we.clouds}</td>
        <td>${we.pressure}</td>
        <td>${we.description}</td>
        <td>${we.date}</td>

    </tr>
    </c:forEach>

</table>
<td>
    <form:form method="post" action="BackToChoice">
        <input type="submit" class="button" name="BackToChoice" value="Powrot do ekranu startowego"/>
    </form:form>
</td>